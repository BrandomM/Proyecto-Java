package com.simecad.simecad.controller;

import com.simecad.simecad.service.EmailService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/contacto")
    public void contactEmail(@RequestBody Map<String, Object> body) {
        String nombre = body.get("nombre").toString();
        String correo = body.get("correo").toString();
        String mensaje = body.get("mensaje").toString();

        String mensajeContacto = "Tienes un mensaje de " + nombre + ": \n" + mensaje + "\n" + "Correo: " + correo;
        String asunto = nombre + " quiere contactarte";

        emailService.sendSimpleMessageToOne("bcmosquerac@gmail.com", asunto, mensajeContacto);
    }

    @PostMapping("/simple/unico")
    public void sendSimpleMessageToOne(@RequestBody Map<String, Object> body) {
        String destinatario = body.get("destinatario").toString();
        String asunto = body.get("asunto").toString();
        String mensaje = body.get("mensaje").toString();

        emailService.sendSimpleMessageToOne(destinatario, asunto, mensaje);
    }

    @PostMapping("/simple/multiple")
    public void sendSimpleMessageToMany(@RequestBody Map<String, Object> body) {
        List<Object> destinatariosObjects = (List<Object>) body.get("destinatarios");

        List<String> destinatariosList = destinatariosObjects.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());

        String[] destinatarios = destinatariosList.toArray(new String[0]);

        String asunto = body.get("asunto").toString();
        String mensaje = body.get("mensaje").toString();

        emailService.sendSimpleMessageToMany(destinatarios, asunto, mensaje);
    }

    @PostMapping("/adjunto/unico")
    public void sendMessageWithAttachmentToOne(@RequestBody Map<String, Object> body) {
        String destinatario = body.get("destinatario").toString();
        String asunto = body.get("asunto").toString();
        String mensaje = body.get("mensaje").toString();

        String pathToAttachment = body.get("url").toString();

        emailService.sendMessageWithAttachmentToOne(destinatario, asunto, mensaje, pathToAttachment, "amonita.jpg");
    }

    @PostMapping("/adjunto/multiple")
    public void sendMessageWithAttachmentToMany(@RequestBody Map<String, Object> body) {
        List<Object> destinatariosObjects = (List<Object>) body.get("destinatarios");
        List<String> destinatariosList = destinatariosObjects.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());
        String[] destinatarios = destinatariosList.toArray(new String[0]);

        String asunto = body.get("asunto").toString();
        String mensaje = body.get("mensaje").toString();

        String pathToAttachment = body.get("url").toString();

        emailService.sendMessageWithAttachmentToMany(destinatarios, asunto, mensaje, pathToAttachment, "amonita.jpg");
    }

}
