package com.alexb.clientui.controller;

import com.alexb.clientui.model.DepartmentDto;
import com.alexb.clientui.model.EmployeeDto;
import com.alexb.clientui.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.PARTIAL_CONTENT;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BaseController {

    private final OrganizationService organizationService;

    @GetMapping(value = "/")
    public String getIndexPage() {
        return "index";
    }

    @ResponseBody
    @GetMapping(value = "/employee/{id}")
    public EmployeeDto getEmployeeByName(@PathVariable(name = "id") Integer id) {
        return organizationService.getEmployee(id);
    }

    @ResponseBody
    @GetMapping(value = "/dept")
    public DepartmentDto departmentByName(@RequestParam(name = "dname") String dname) {
        return organizationService.getDepartmentByName(dname);
    }

    @PatchMapping(value = "/employee/{id}")
    @ResponseBody
    public EmployeeDto employeeDto(@PathVariable(name = "id") Integer id,
                                   @RequestBody EmployeeDto employeeDto) {
        return organizationService.editEmployee(id, employeeDto);
    }

    @GetMapping(value = "/employee/dept/{id}")
    @ResponseBody
    public List<EmployeeDto> getEmployees(@PathVariable(name = "id") Integer id) {
        return organizationService.getEmployees(id);
    }

    @GetMapping(value = "/images/man", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getMImage() throws URISyntaxException, IOException {
        Path path = Paths.get(ClassLoader.getSystemResource("static/sex_male.png").toURI());
        byte[] media = Files.readAllBytes(path);
        return ResponseEntity.ok(media);
    }

    @GetMapping(value = "/videosrc")
    @ResponseBody
    public ResponseEntity<byte[]> videoSource() throws IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("static/video.mp4").toURI());

        byte[] bytes = Files.readAllBytes(path);

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("Content-Type", "video/mp4");
        responseHeader.add("Accept-Ranges", "bytes");
        responseHeader.add("ETag", String.valueOf(path.getFileName()));
        responseHeader.add("Content-Length", "" + (bytes.length) + "");
        responseHeader.add("Content-Range", "bytes " + 0 + "-" + (bytes.length - 1) + "/" + bytes.length);

        return new ResponseEntity<>(Files.readAllBytes(path), responseHeader, OK);
    }


    @GetMapping(value = "/videosrc2")
    @ResponseBody
    public ResponseEntity<InputStreamResource> videoSource2(@RequestHeader(value = "Range", required = false) String range) throws IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("static/video.mp4").toURI());


        long rangeStart = 0;
        long rangeEnd = path.toFile().length();
        if (range != null) {
            rangeStart = Long.parseLong(range.replace("bytes=", "").split("-")[0]); // parse startvalue
        }
        long contentLenght = path.toFile().length();//you must have it somewhere stored or read the full file size

        InputStream inputStream = Files.newInputStream(path);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "video/mp4");
        headers.set("Accept-Ranges", "bytes");
        headers.set("Expires", "0");
        headers.set("Cache-Control", "no-cache, no-store");
        headers.set("Connection", "keep-alive");
        headers.set("Content-Transfer-Encoding", "binary");
        headers.set("Content-Length", String.valueOf(rangeEnd - rangeStart));


//        https://stackoverflow.com/questions/23615091/java-multimedia-streaming-via-html5-video-element

//if start range assume that all content
        if (rangeStart == 0) {
            return new ResponseEntity<>(new InputStreamResource(inputStream), headers, OK);
        } else {
            headers.set("Content-Range", format("bytes %s-%s/%s", rangeStart, rangeEnd, contentLenght));
            return new ResponseEntity<>(new InputStreamResource(inputStream), headers, PARTIAL_CONTENT);
        }
    }

    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public ResponseEntity<?> getContent() throws URISyntaxException, IOException {

        Path path = Paths.get(ClassLoader.getSystemResource("static/video.mp4").toURI());

        InputStreamResource inputStreamResource = new InputStreamResource(Files.newInputStream(path));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(Files.size(path));
        headers.set("Content-Type", "video/mp4");
        return new ResponseEntity<Object>(inputStreamResource, headers, OK);
    }


    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus
    public void handleError(Throwable throwable) {
        log.error(throwable.getMessage());
    }
}
