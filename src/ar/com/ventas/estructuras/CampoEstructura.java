/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.estructuras;

import ar.com.ventas.entities.Persona;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.services.PersonaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mario
 */
public enum CampoEstructura {
    FECHAENTREGADO(1, "FECHA DE ENTREGA") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            Date f;
            try {
                f = sdf.parse(fecha2Txt.getText());
            } catch (ParseException ex) {
                Logger.getLogger(CampoEstructura.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR EN FECHA");
                fecha2Txt.requestFocus();
                return;
            }
            String str = sdf.format(f);
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            return dato;
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            fecha2Txt.setText("");
            fechaLbl.setVisible(true);
            fecha2Txt.setVisible(true);
            fecha2Txt.requestFocus();
        }
    },
    FECHARETIRADO(2, "FECHA DE RETIRO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            Date f;
            try {
                f = sdf.parse(fecha2Txt.getText());
            } catch (ParseException ex) {
                Logger.getLogger(CampoEstructura.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR EN FECHA");
                fecha2Txt.requestFocus();
                return;
            }
            String str = sdf.format(f);
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            return dato;
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "";
        }

        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            fecha2Txt.setText("");
            fechaLbl.setVisible(true);
            fecha2Txt.setVisible(true);
            fecha2Txt.requestFocus();
        }
    },
    FECHAVENCIMIENTO(3, "FECHA DE VENCIMIENTO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            Date f;
            try {
                f = sdf.parse(fecha2Txt.getText());
            } catch (ParseException ex) {
                Logger.getLogger(CampoEstructura.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR EN FECHA");
                fecha2Txt.requestFocus();
                return;
            }
            String str = sdf.format(f);
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            return dato;
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            fecha2Txt.setText("");
            fechaLbl.setVisible(true);
            fecha2Txt.setVisible(true);
            fecha2Txt.requestFocus();
        }
    },
    FECHAREALIZADO(4, "FECHA DE REALIZADO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            Date f;
            try {
                f = sdf.parse(fecha2Txt.getText());
            } catch (ParseException ex) {
                Logger.getLogger(CampoEstructura.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR EN FECHA");
                fecha2Txt.requestFocus();
                return;
            }
            String str = sdf.format(f);
            renglon.setContenido(str);
//            Trabajo t = renglon.getTrabajo();
//            t.setFecha(f);
//            try {
//                new TrabajoService().updateTrabajo(t);
//            } catch (Exception ex) {
//                Logger.getLogger(CampoEstructura.class.getName()).log(Level.SEVERE, null, ex);
//            }
////            System.out.println(t.getFecha());
////            System.exit(0);
        }

        @Override
        public String mostrarCampos(String dato) {
            return dato;
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            String fe = sdf.format(fecha);
            return fe;
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            fecha2Txt.setText("");
            fechaLbl.setVisible(true);
            fecha2Txt.setVisible(true);
            fecha2Txt.requestFocus();
        }
    },
    FECHAINFORMATIVA(5, "FECHA INFORMATIVA") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            Date f;
            try {
                f = sdf.parse(fecha2Txt.getText());
            } catch (ParseException ex) {
                Logger.getLogger(CampoEstructura.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR EN FECHA");
                fecha2Txt.requestFocus();
                return;
            }
            String str = sdf.format(f);
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            return dato;
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            fecha2Txt.setText("");
            fechaLbl.setVisible(true);
            fecha2Txt.setVisible(true);
            fecha2Txt.requestFocus();
        }
    },
    PERSONAREALIZOTRABAJO(6, "PERSONA QUE REALIZO TRABAJO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            Persona persona = personas.get(linP - 1);
            String str = persona.getId().toString();
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            Long i = Long.valueOf(dato);

            String nombre;
            try {
                nombre = new PersonaService().getPersonaActivaById(i);
            } catch (Exception ex) {
                Logger.getLogger(CampoEstructura.class.getName()).log(Level.SEVERE, null, ex);
                nombre = "ERROR Nro 143";
            }

            return nombre;
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            comboP.setVisible(true);
            personaLbl.setVisible(true);
            comboP.requestFocus();
            comboP.addFocusListener(null);
            comboP.showPopup();
        }
    },
    TEXTOINFORMATIVO(7, "TEXTO INFORMATIVO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String texto) {
            renglon.setContenido(texto);
        }

        @Override
        public String mostrarCampos(String dato) {
            return dato;
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            textoLbl.setVisible(true);
            textoTxt.setVisible(true);
            textoTxt.setText("");
            textoTxt.requestFocus();
        }
    },
    IMPORTE(8, "IMPORTE") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String mostrarCampos(String dato) {
            return "8";
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            importeLbl.setVisible(true);
            importeTxt.setVisible(true);
            importeTxt.setText("");
            importeTxt.requestFocus();
        }
    },
    CANTIDAD(9, "CANTIDAD") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String mostrarCampos(String dato) {
            return "9";
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            cantidadLbl.setVisible(true);
            cantidadTxt.setVisible(true);
            cantidadTxt.setText("");
            cantidadTxt.requestFocus();
        }
    },
    CONFIRMARREALIZADO(10, "CONFIRMAR REALIZADO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            String str = "";
            if (linO == 1) {
                str = "1";
            } else {
                str = "2";
            }
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            if (dato.equals("1")) {
                return "SI";
            } else {
                return "NO";
            }
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "2";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            opcionLbl.setVisible(true);
            comboO.setVisible(true);
            comboO.requestFocus();
        }
    },
    CONFIRMARENTREGADO(11, "CONFIRMAR TERMINADO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            String str = "";
            if (linO == 1) {
                str = "1";
            } else {
                str = "2";
            }
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            if (dato.equals("1")) {
                return "SI";
            } else {
                return "NO";
            }
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "2";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            opcionLbl.setVisible(true);
            comboO.setVisible(true);
            comboO.requestFocus();
        }
    },
    CONFIRMARPAGADO(12, "CONFIRMAR PAGADO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            String str = "";
            if (linO == 1) {
                str = "1";
            } else {
                str = "2";
            }
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            if (dato.equals("1")) {
                return "SI";
            } else {
                return "NO";
            }
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "2";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            opcionLbl.setVisible(true);
            comboO.setVisible(true);
            comboO.requestFocus();
        }
    },
    TEXTODEOBSERVACIONES(13, "TEXTO DE OBSERVACIONES") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            renglon.setContenido(caracteristicas);
        }

        @Override
        public String mostrarCampos(String dato) {
            return dato;
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return caracteristicas;
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            textoLbl.setVisible(true);
            textoTxt.setVisible(true);
            textoTxt.setText(content);
            textoTxt.requestFocus();
        }
    },
    TEXTOCONVERIFICACION(14, "TEXTO CON VERIFICACION") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String mostrarCampos(String dato) {
            return "14";
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            textoLbl.setVisible(true);
            textoTxt.setVisible(true);
            textoTxt.setText(content);
            textoTxt.requestFocus();
        }
    },
    ANALISISBACTERIOLOGICO(15, "ANALISIS BACTERIOLOGICO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            String str = "";
            if (linO == 1) {
                str = "1";
            } else {
                str = "2";
            }
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            if (dato.equals("1")) {
                return "SI";
            } else {
                return "NO";
            }
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            if (bacterio) {
                return "1";
            } else {
                return "2";
            }
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            opcionLbl.setVisible(true);
            comboO.setVisible(true);
//            System.out.println(content);
//            System.exit(0);
            if (content.equals("1")) {
                comboO.setSelectedIndex(1);
            } else {
                comboO.setSelectedIndex(2);
            }
            comboO.requestFocus();
        }
    },
    ANALISISFISICOQUIMICO(16, "ANALISIS FISICO QUIMICO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            String str = "";
            if (linO == 1) {
                str = "1";
            } else {
                str = "2";
            }
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            if (dato.equals("1")) {
                return "SI";
            } else {
                return "NO";
            }
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            if (fisicoQui) {
                return "1";
            } else {
                return "2";
            }
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            opcionLbl.setVisible(true);
            comboO.setVisible(true);
//            System.out.println(content);
//            System.exit(0);
            if (content.equals("1")) {
                comboO.setSelectedIndex(1);
            } else {
                comboO.setSelectedIndex(2);
            }
            comboO.requestFocus();
        }
    },
    CONFIRMARCERTIFICADO(17, "CERTIFICADO EMITIDO") {
        @Override
        public void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas) {
            String str = "";
            if (linO == 1) {
                str = "1";
            } else {
                str = "2";
            }
            renglon.setContenido(str);
        }

        @Override
        public String mostrarCampos(String dato) {
            if (dato.equals("1")) {
                return "SI";
            } else {
                return "NO";
            }
        }

        @Override
        public String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui) {
            return "2";
        }

        @Override
        public void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
                JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content) {
            opcionLbl.setVisible(true);
            comboO.setVisible(true);
            if (content.equals("1")) {
                comboO.setSelectedIndex(1);
            } else {
                comboO.setSelectedIndex(2);
            }
            comboO.requestFocus();
        }
    };

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final Integer codigo;
    private final String campo;

    CampoEstructura(Integer codigo, String campo) {
        this.codigo = codigo;
        this.campo = campo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getCampo() {
        return campo;
    }

    public abstract void cargarCampos(JTextField fecha2Txt, RenglonTrabajo renglon, int linP, List<Persona> personas, int linO, String caracteristicas);

    public abstract String mostrarCampos(String dato);

    public abstract String crearCampo(Date fecha, String caracteristicas, Boolean bacterio, Boolean fisicoQui);

    public abstract void visualizarCampos(JComboBox comboP, JTextField fecha2Txt, JTextField textoTxt, JTextField cantidadTxt, JTextField importeTxt, JComboBox comboO,
            JLabel personaLbl, JLabel fechaLbl, JLabel textoLbl, JLabel cantidadLbl, JLabel importeLbl, JLabel opcionLbl, String content);

    public static CampoEstructura fromCodigo(Integer codigo) {
        return Arrays.asList(values()).stream()
                .filter(campo -> campo.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new RuntimeException());

    }

    public static String getDescriptionByCode(Integer codigo) {
        return Arrays.asList(values()).stream()
                .filter(campo -> campo.getCodigo().equals(codigo))
                .findFirst()
                .map(campo -> campo.getCampo())
                .orElseThrow(() -> new RuntimeException());
    }
}
