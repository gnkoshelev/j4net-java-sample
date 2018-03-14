package ru.gnkoshelev.j4net.sample.hash.spring.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gnkoshelev.j4net.sample.hash.lib.Hasher;
import ru.gnkoshelev.j4net.sample.hash.spring.service.dto.HashRequest;
import ru.gnkoshelev.j4net.sample.hash.spring.service.dto.HashResponse;

/**
 * Created by kgn on 14.03.2018.
 */
@Controller
public class HashController {
    @RequestMapping(value = "/{algorithm}/compute", method = RequestMethod.POST)
    @ResponseBody
    public HashResponse compute(@PathVariable String algorithm, @RequestBody HashRequest request) {
        try {
            return HashResponse.ok(Hasher.compute(algorithm, request.getBytes()));
        } catch (Exception exception) {
            return HashResponse.error();
        }
    }
}
