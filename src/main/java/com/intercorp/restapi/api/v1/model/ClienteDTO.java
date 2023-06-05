package com.intercorp.restapi.api.v1.model;


import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Cliente data transfer object model
 */
@ApiModel(value = "Cliente", description = "cliente")
@Data

public class ClienteDTO {

    @ApiModelProperty(value = "Nombre", required = true, allowEmptyValue = false, position = 0)
    @NotBlank
    @Size(min = 1, max = 255)
    private String nombre;


    @ApiModelProperty(value = "Apellido", required = true, allowEmptyValue = false, position = 1)
    @NotBlank
    @Size(min = 1, max = 255)
    private String apellido;

    @ApiModelProperty(required = true, allowEmptyValue = false, position = 2)
    private int edad;
    
    @ApiModelProperty(value = "11/11/1999", required = true, allowEmptyValue = false, position = 3)
    @NotBlank
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$") 
    private String fechaNacimiento;
    
    @ApiModelProperty(value = "11/11/1999", required = true, allowEmptyValue = false, position = 3)
    @NotBlank
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$") 
    private String fechaMuerte;
    
    @ApiModelProperty(value = "Only available in response", readOnly = true, position = 4)
    private String clienteUrl;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getClienteUrl() {
		return clienteUrl;
	}

	public void setClienteUrl(String clienteUrl) {
		this.clienteUrl = clienteUrl;
	}

	public String getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(String fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

	public ClienteDTO(@NotBlank @Size(min = 1, max = 255) String nombre,
			@NotBlank @Size(min = 1, max = 255) String apellido, int edad,
			@NotBlank @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$") String fechaNacimiento,
			@NotBlank @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$") String fechaMuerte,
			String clienteUrl) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaMuerte = fechaMuerte;
		this.clienteUrl = clienteUrl;
	}

	public ClienteDTO() {
		super();
	}
	
    
}
