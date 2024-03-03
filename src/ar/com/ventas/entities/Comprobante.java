/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

import java.util.Date;

/**
 *
 * @author Mario
 */
public class Comprobante {

    private Long id;
    private String cuitTitular;
    private String razonSocialTitular;
    private String iibb;
    private Date fechaInicioActividades;
    private String domicilioTitular;
    private String codigoPostalAndLocalidadTitular;
    private String provinciaTitular;
    private Integer codigoComprobante;
    private Date fecha;
    private Date fechaPeriodoDesde;
    private Date fechaPeriodoHasta;
    private Date fechaVencimientoPago;
    private String periodo;
    private String letra;
    private Boolean pdfGenerado;
    private Integer sucursal;
    private Integer numero;
    private String razonSocialCliente;
    private String calleNroPisoDtoCliente;
    private String codigoPostalAndLocalidadCliente;
    private String provinciaCliente;
    private String tipoDocumento;
    private String cuitCliente;
    private Integer codigoCliente;
    private String tipoInscripcion;
    private Double gravado;
    private Double iva;
    private Double total;
    private Double pagado;
    private Integer cantidadCuotas;
    private Integer cuotasPagadas;
    private Long cae;
    private Date fechaVencimientoCae;
    private Integer tipoComprobanteAsociado;
    private String letraComprobanteAsociado;
    private Integer sucursalComprobanteAsociado;
    private Integer numeroComprobanteAsociado;
    private Integer tipoEmision;
    private Rubro rubro;
    private String texto1;
    private String texto2;
    private Integer productoServicio;
    private Long id_original;
    private Boolean original;
    private Long id_administrador;
    private FondoRecibo fondo;
    private Boolean cuotaSiguienteFacturada;
    private Boolean periodoHabilitado;

    /*
    tipo emision
    FACTURA ABONO 2
    FACTURA REPARACION 3
    RECIBO ABONO 1
    RECIBO REPARACION 4
     */
    public Comprobante() {
    }

    public Comprobante(Long id, String cuitTitular, String razonSocialTitular, String iibb, String periodo,
            Date fechaInicioActividades, String domicilioTitular, String codigoPostalAndLocalidadTitular,
            String provinciaTitular, Integer codigoComprobante, Date fecha, Date fechaPeriodoDesde,
            Date fechaPeriodoHasta, Date fechaVencimientoPago, String letra, Boolean pdfGenerado,
            Integer sucursal, Integer numero, String razonSocialCliente, String calleNroPisoDtoCliente,
            String codigoPostalAndLocalidadCliente, String provinciaCliente, String tipoDocumento, String cuitCliente,
            Integer codigoCliente, String tipoInscripcion, Double gravado, Double iva, Double total, Double pagado, Integer cantidadCuotas,
            Integer cuotasPagadas, Long cae, Date fechaVencimientoCae, Integer tipoComprobanteAsociado,
            String letraComprobanteAsociado, Integer sucursalComprobanteAsociado, Integer numeroComprobanteAsociado,
            Integer tipoEmision, Rubro rubro, String texto1, String texto2, Integer productoServicio,
            Long id_original, Boolean original, Long id_administrador, FondoRecibo fondo,
            Boolean cuotaSiguienteFacturada, Boolean periodoHabilitado) {
        this.id = id;
        this.cuitTitular = cuitTitular;
        this.razonSocialTitular = razonSocialTitular;
        this.iibb = iibb;
        this.fechaInicioActividades = fechaInicioActividades;
        this.domicilioTitular = domicilioTitular;
        this.codigoPostalAndLocalidadTitular = codigoPostalAndLocalidadTitular;
        this.provinciaTitular = provinciaTitular;
        this.codigoComprobante = codigoComprobante;
        this.fecha = fecha;
        this.fechaPeriodoDesde = fechaPeriodoDesde;
        this.fechaPeriodoHasta = fechaPeriodoHasta;
        this.fechaVencimientoPago = fechaVencimientoPago;
        this.letra = letra;
        this.pdfGenerado = pdfGenerado;
        this.sucursal = sucursal;
        this.numero = numero;
        this.razonSocialCliente = razonSocialCliente;
        this.calleNroPisoDtoCliente = calleNroPisoDtoCliente;
        this.codigoPostalAndLocalidadCliente = codigoPostalAndLocalidadCliente;
        this.provinciaCliente = provinciaCliente;
        this.tipoDocumento = tipoDocumento;
        this.cuitCliente = cuitCliente;
        this.codigoCliente = codigoCliente;
        this.tipoInscripcion = tipoInscripcion;
        this.gravado = gravado;
        this.iva = iva;
        this.total = total;
        this.pagado = pagado;
        this.cantidadCuotas = cantidadCuotas;
        this.cuotasPagadas = cuotasPagadas;
        this.cae = cae;
        this.fechaVencimientoCae = fechaVencimientoCae;
        this.tipoComprobanteAsociado = tipoComprobanteAsociado;
        this.letraComprobanteAsociado = letraComprobanteAsociado;
        this.sucursalComprobanteAsociado = sucursalComprobanteAsociado;
        this.numeroComprobanteAsociado = numeroComprobanteAsociado;
        this.tipoEmision = tipoEmision;
        this.rubro = rubro;
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.productoServicio = productoServicio;
        this.periodo = periodo;
        this.id_original = id_original;
        this.original = original;
        this.periodoHabilitado = periodoHabilitado;
        this.id_administrador = id_administrador;
        this.fondo = fondo;
        this.cuotaSiguienteFacturada = cuotaSiguienteFacturada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuitTitular() {
        return cuitTitular;
    }

    public void setCuitTitular(String cuitTitular) {
        this.cuitTitular = cuitTitular;
    }

    public String getRazonSocialTitular() {
        return razonSocialTitular;
    }

    public void setRazonSocialTitular(String razonSocialTitular) {
        this.razonSocialTitular = razonSocialTitular;
    }

    public String getIibb() {
        return iibb;
    }

    public void setIibb(String iibb) {
        this.iibb = iibb;
    }

    public Date getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public void setFechaInicioActividades(Date fechaInicioActividades) {
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public String getDomicilioTitular() {
        return domicilioTitular;
    }

    public void setDomicilioTitular(String domicilioTitular) {
        this.domicilioTitular = domicilioTitular;
    }

    public String getCodigoPostalAndLocalidadTitular() {
        return codigoPostalAndLocalidadTitular;
    }

    public void setCodigoPostalAndLocalidadTitular(String codigoPostalAndLocalidadTitular) {
        this.codigoPostalAndLocalidadTitular = codigoPostalAndLocalidadTitular;
    }

    public String getProvinciaTitular() {
        return provinciaTitular;
    }

    public void setProvinciaTitular(String provinciaTitular) {
        this.provinciaTitular = provinciaTitular;
    }

    public Integer getCodigoComprobante() {
        return codigoComprobante;
    }

    public void setCodigoComprobante(Integer codigoComprobante) {
        this.codigoComprobante = codigoComprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaPeriodoDesde() {
        return fechaPeriodoDesde;
    }

    public void setFechaPeriodoDesde(Date fechaPeriodoDesde) {
        this.fechaPeriodoDesde = fechaPeriodoDesde;
    }

    public Date getFechaPeriodoHasta() {
        return fechaPeriodoHasta;
    }

    public void setFechaPeriodoHasta(Date fechaPeriodoHasta) {
        this.fechaPeriodoHasta = fechaPeriodoHasta;
    }

    public Date getFechaVencimientoPago() {
        return fechaVencimientoPago;
    }

    public void setFechaVencimientoPago(Date fechaVencimientoPago) {
        this.fechaVencimientoPago = fechaVencimientoPago;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Boolean getPdfGenerado() {
        return pdfGenerado;
    }

    public void setPdfGenerado(Boolean pdfGenerado) {
        this.pdfGenerado = pdfGenerado;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRazonSocialCliente() {
        return razonSocialCliente;
    }

    public void setRazonSocialCliente(String razonSocialCliente) {
        this.razonSocialCliente = razonSocialCliente;
    }

    public String getCalleNroPisoDtoCliente() {
        return calleNroPisoDtoCliente;
    }

    public void setCalleNroPisoDtoCliente(String calleNroPisoDtoCliente) {
        this.calleNroPisoDtoCliente = calleNroPisoDtoCliente;
    }

    public String getCodigoPostalAndLocalidadCliente() {
        return codigoPostalAndLocalidadCliente;
    }

    public void setCodigoPostalAndLocalidadCliente(String codigoPostalAndLocalidadCliente) {
        this.codigoPostalAndLocalidadCliente = codigoPostalAndLocalidadCliente;
    }

    public String getProvinciaCliente() {
        return provinciaCliente;
    }

    public void setProvinciaCliente(String provinciaCliente) {
        this.provinciaCliente = provinciaCliente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(String cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getTipoInscripcion() {
        return tipoInscripcion;
    }

    public void setTipoInscripcion(String tipoInscripcion) {
        this.tipoInscripcion = tipoInscripcion;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPagado() {
        return pagado;
    }

    public void setPagado(Double pagado) {
        this.pagado = pagado;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(Integer cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public Integer getCuotasPagadas() {
        return cuotasPagadas;
    }

    public void setCuotasPagadas(Integer cuotasPagadas) {
        this.cuotasPagadas = cuotasPagadas;
    }

    public Long getCae() {
        return cae;
    }

    public void setCae(Long cae) {
        this.cae = cae;
    }

    public Date getFechaVencimientoCae() {
        return fechaVencimientoCae;
    }

    public void setFechaVencimientoCae(Date fechaVencimientoCae) {
        this.fechaVencimientoCae = fechaVencimientoCae;
    }

    public Integer getTipoComprobanteAsociado() {
        return tipoComprobanteAsociado;
    }

    public void setTipoComprobanteAsociado(Integer tipoComprobanteAsociado) {
        this.tipoComprobanteAsociado = tipoComprobanteAsociado;
    }

    public String getLetraComprobanteAsociado() {
        return letraComprobanteAsociado;
    }

    public void setLetraComprobanteAsociado(String letraComprobanteAsociado) {
        this.letraComprobanteAsociado = letraComprobanteAsociado;
    }

    public Integer getSucursalComprobanteAsociado() {
        return sucursalComprobanteAsociado;
    }

    public void setSucursalComprobanteAsociado(Integer sucursalComprobanteAsociado) {
        this.sucursalComprobanteAsociado = sucursalComprobanteAsociado;
    }

    public Integer getNumeroComprobanteAsociado() {
        return numeroComprobanteAsociado;
    }

    public void setNumeroComprobanteAsociado(Integer numeroComprobanteAsociado) {
        this.numeroComprobanteAsociado = numeroComprobanteAsociado;
    }

    public Integer getTipoEmision() {
        return tipoEmision;
    }

    public void setTipoEmision(Integer tipoEmision) {
        this.tipoEmision = tipoEmision;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public String getTexto1() {
        return texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }

    public Integer getProductoServicio() {
        return productoServicio;
    }

    public void setProductoServicio(Integer productoServicio) {
        this.productoServicio = productoServicio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Long getId_original() {
        return id_original;
    }

    public void setId_original(Long id_original) {
        this.id_original = id_original;
    }

    public Boolean getOriginal() {
        return original;
    }

    public void setOriginal(Boolean original) {
        this.original = original;
    }

    public Long getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(Long id_administrador) {
        this.id_administrador = id_administrador;
    }

    public FondoRecibo getFondo() {
        return fondo;
    }

    public void setFondo(FondoRecibo fondo) {
        this.fondo = fondo;
    }

    public Boolean getCuotaSiguienteFacturada() {
        return cuotaSiguienteFacturada;
    }

    public void setCuotaSiguienteFacturada(Boolean cuotaSiguienteFacturada) {
        this.cuotaSiguienteFacturada = cuotaSiguienteFacturada;
    }

    public Boolean getPeriodoHabilitado() {
        return periodoHabilitado;
    }

    public void setPeriodoHabilitado(Boolean periodoHabilitado) {
        this.periodoHabilitado = periodoHabilitado;
    }

}
