package edu.fullerton.csu.jmtran.projectx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

@Controller
public class MailboxController {

    @RequestMapping(value="/api/v0/mailbox", method=RequestMethod.GET)
    @ResponseBody
    public String getMessages(@RequestParam(value = "userId", required = false) String userId) {
        if(userId == null) {
            return "getMessages()";
        }

        return "getMessages(" + userId + ")";
    }

    @RequestMapping(value = "/api/v0/mailbox/{messageId}", method = RequestMethod.GET)
    @ResponseBody
    public String getMessage(@PathVariable("messageId") String messageId) {
        if(messageId == null) {
            return "getMessage()";
        }

        return "getMessage(" + messageId + ")";
    }

    @RequestMapping(value = "/api/v0/mailbox/{messageId}", method = RequestMethod.POST)
    @ResponseBody
    public String setMessageState(@PathVariable("messageId") String messageId, @RequestParam("state") String state) {
        if(messageId == null || state == null) {
            return "setMessageState()";
        }

        return "setMessageState(" + messageId + ", " + state + ")";
    }

}
