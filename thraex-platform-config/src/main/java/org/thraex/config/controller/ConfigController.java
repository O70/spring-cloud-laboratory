package org.thraex.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thraex.config.entity.Application;
import org.thraex.config.entity.Properties;
import org.thraex.config.service.ConfigService;

import java.util.List;

/**
 * @Author 鬼王
 * @Date 2018/11/23 15:37
 */
@Controller
@RequestMapping("config")
public class ConfigController {

    @Value("${spring.cloud.config.server.prefix:}")
    private String PREFIX;

    @Autowired
    private ConfigService configService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute(configService.findAll());
        model.addAttribute("prefix", PREFIX);
        return "home";
    }

    @PostMapping("save")
    @ResponseBody
    public ResponseEntity<Application> save(Application application) {
        return ResponseEntity.ok(configService.save(application));
    }

    @PostMapping("save/all")
    @ResponseBody
    public ResponseEntity<List<Application>> saveAll(@RequestBody List<Application> appList) {
        return ResponseEntity.ok(configService.save(appList));
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable String id) {
        configService.delete(id);
        return "redirect:/config";
    }

    @GetMapping("detail/{pid}")
    public String detail(@PathVariable String pid, Model model) {
        model.addAttribute("app", configService.findById(pid));
        model.addAttribute(configService.findByPid(pid));
        return "detail";
    }

    @PostMapping("detail/save")
    @ResponseBody
    public ResponseEntity<Properties> saveProperties(Properties properties) {
        return ResponseEntity.ok(configService.saveProperties(properties));
    }

    @PostMapping("detail/save/all")
    @ResponseBody
    public ResponseEntity<List<Properties>> saveProperties(@RequestBody List<Properties> propList) {
        return ResponseEntity.ok(configService.saveProperties(propList));
    }

    @GetMapping("detail/delete/{pid}/{id}")
    public String deleteProperties(@PathVariable String pid, @PathVariable String id) {
        configService.deleteProperties(id);
        return "redirect:/config/detail/"+pid;
    }

}
