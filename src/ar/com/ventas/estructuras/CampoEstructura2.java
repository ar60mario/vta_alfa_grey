/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.estructuras;

/**
 *
 * @author Mario
 */
public enum CampoEstructura2 {
    FECHAENTREGADO(1,"FECHA DE ENTREGA") {
        @Override
        public String hacerAlgo() {
            return "hola soy fecha de entrega";
        }
    },
    FECHARETIRADO(2,"FECHA DE RETIRO") {
        @Override
        public String hacerAlgo() {
           return "Hola soy fecha retiro";
        }
    },
    FECHAVENCIMIENTO(3,"FECHA DE VENCIMIENTO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    FECHAREALIZADO(4,"FECHA DE REALIZADO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    FECHAINFORMATIVA(5,"FECHA INFORMATIVA") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    PERSONAREALIZOTRABAJO(6,"PERSONA QUE REALIZO TRABAJO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    TEXTOINFORMATIVO(7,"TEXTO INFORMATIVO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    IMPORTE(8,"IMPORTE") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    CANTIDAD(9,"CANTIDAD") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    CONFIRMARREALIZADO(10,"CONFIRMAR REALIZADO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    CONFIRMARENTREGADO(11,"CONFIRMAR TERMINADO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    CONFIRMARPAGADO(12,"CONFIRMAR PAGADO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    TEXTODEOBSERVACIONES(13,"TEXTO DE OBSERVACIONES") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    TEXTOCONVERIFICACION(14,"TEXTO CON VERIFICACION") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    ANALISISBACTERIOLOGICO(15,"ANALISIS BACTERIOLOGICO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    ANALISISFISICOQUIMICO(16,"ANALISIS FISICO QUIMICO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    CONFIRMARCERTIFICADO(17,"CERTIFICADO EMITIDO") {
        @Override
        public String hacerAlgo() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    private final Integer codigo;
    private final String campo;
    
    CampoEstructura2(Integer codigo, String campo){
        this.codigo=codigo;
        this.campo = campo;
    }
    
    public Integer getCodigo(){
        return codigo;
    }
    
    public String getCampo(){
        return campo;
    }
    
    public abstract String hacerAlgo();
}
