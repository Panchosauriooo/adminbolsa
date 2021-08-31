package com.bolsa;

import java.util.ArrayList;

public class Empresa {
    private String rut;
    private String nombre;
    private String direccion;
    private String paginaWeb;
    private String correo;
    private String telefono;
    private ArrayList<PuestoDeTrabajo> puestosDeTrabajo;

    public Empresa(String rut, String nombre, String direccion, String paginaWeb, String correo, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.paginaWeb = paginaWeb;
        this.correo = correo;
        this.telefono = telefono;
        this.puestosDeTrabajo = new ArrayList<>();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (rut.charAt(rut.length() - 2) != '-') {
            String rutPreGuion = rut.substring(0, rut.length() - 1);
            this.rut = rutPreGuion + '-' + rut.charAt(rut.length() - 1);
            return;
        }
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<PuestoDeTrabajo> getPuestosDeTrabajo() {
        return new ArrayList<>(this.puestosDeTrabajo);
    }

    public void setPuestosDeTrabajo(ArrayList<PuestoDeTrabajo> puestosDeTrabajo) {
        this.puestosDeTrabajo = puestosDeTrabajo;
    }

    public void anadirPuestoDeTrabajo(PuestoDeTrabajo puesto) {
        this.puestosDeTrabajo.add(puesto);
    }

    public PuestoDeTrabajo buscarPuestoDeTrabajo(int id) {
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            if (puesto.getId() == id) {
                return puesto;
            }
        }

        return null;
    }

    public void mostrarEmpresa() {
        int i = 1;
        System.out.println("Rut: " + this.rut);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Pagina web: " + this.paginaWeb);
        System.out.println("Correo: " + this.correo);
        System.out.println("Telefono: " + this.telefono);
        System.out.println();

        System.out.println("###   Puestos de trabajo   ###");
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            System.out.println("###   Puesto N°" + i + "   ###");
            puesto.mostrarPuestoDeTrabajo();
            i++;
        }
    }
}