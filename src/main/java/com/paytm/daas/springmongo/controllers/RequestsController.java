package com.paytm.daas.springmongo.controllers;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paytm.daas.springmongo.constants.URLConstants;
import com.paytm.daas.springmongo.dto.response.ErrorDetails;
import com.paytm.daas.springmongo.dto.response.ErrorResponse;
import com.paytm.daas.springmongo.dto.response.SuccessResponse;

import com.paytm.daas.springmongo.exceptions.InvalidMongoException;
import com.paytm.daas.springmongo.services.InsightsService;

import com.paytm.daas.springmongo.utils.LogMessageGenerator;

@RestController
public class RequestsController {

    private InsightsService insightsService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestsController.class);

    @Autowired
    public RequestsController(InsightsService insightsService) {

        this.insightsService = insightsService;
    }

    @RequestMapping(value = URLConstants.GET_INSIGHTS_BY_SEVERITY, method = RequestMethod.GET)
    public ResponseEntity<?> getBySeverity(@RequestParam Integer severity) throws InvalidMongoException {
        try {

            Long start = System.currentTimeMillis();
            LOGGER.info("Request recieved to fetch the data from the DB");

            SuccessResponse successResponse = new SuccessResponse("SUCCESS", insightsService.getInsightsBySeverity(severity));

            Long timeTaken = System.currentTimeMillis() - start;
            LOGGER.info(LogMessageGenerator.getLogMessage("Total time taken to fetch the Data from the DB", timeTaken));

            return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
        } catch (InvalidMongoException e) {

            ErrorResponse errorResponse = new ErrorResponse("FAIL", new ErrorDetails(e.getErrorMessages().getMessage()));
            return new ResponseEntity<ErrorResponse>(errorResponse, e.getErrorMessages().getStatus());
        }
    }
}
