package com.theEspProject.EspProjectWebApi.controller;


import com.theEspProject.EspProjectWebApi.model.RelayValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@RestController
@RequestMapping("/loggingApi")
public class LoggingController {

    @PostMapping(value = "/v1/writeRelayStatus" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity writeRelayStatusInFile(@RequestBody RelayValue currentValue){
        System.out.println("currentValue" + currentValue);


        String filePath = "H:\\EspLogs";
        String currentDate = LocalDate.now().toString();
        String fileName = "log-"+ currentDate + ".txt";
        File file = new File(filePath , fileName);

        String logToWrite = LocalTime.now() + " ---> " + currentValue + "\n";

        try{
            if(file.createNewFile()){
                System.out.println("File created at specific path");
            }
            String pathToWrite = "H://EspLogs//"+fileName;
            Path path = Paths.get(pathToWrite);
            System.out.println(path);
            Files.write(path, logToWrite.getBytes() , StandardOpenOption.APPEND);

             return new ResponseEntity("Log Created Successfully" , HttpStatus.resolve(200));

        } catch (IOException e) {
            return new ResponseEntity("Logs not created" , HttpStatus.resolve(500));
        }




    }
}
