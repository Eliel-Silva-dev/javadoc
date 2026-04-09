package com.alura.reservaSala.models;

import java.time.LocalDateTime;

public class ReservaModel {

    private Long id;
    private UsuarioModel usuarioReserva;
    private SalaModel salaReserva;

    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    private StatusReserva status;

}
