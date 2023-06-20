package com.example.trabajo.services;


public class CalculadoraImpuestoImpl implements PuedeCalcularImpuesto {


    private double limiteInferior;
    private double limiteSuperior;
    private double cuotaFija;
    private double porcentajeSobreExcedente;

    private double ingresoGravable;

    public CalculadoraImpuestoImpl(double ingresoGravable) {
        this.ingresoGravable = ingresoGravable;
    }

    @Override
    public double calcularImpuesto() {

        if (ingresoGravable>=0.01 && ingresoGravable<=496.07){//*** fila 1
            limiteInferior = 0.01;
            limiteSuperior= 496.07;
            cuotaFija=0.00;
            porcentajeSobreExcedente=0.0192;
        }else if (ingresoGravable>=496.08 && ingresoGravable<=4210.41){//*** fila 2
            limiteInferior = 496.08 ;
            limiteSuperior= 4210.41 ;
            cuotaFija=  9.52;
            porcentajeSobreExcedente= 0.064;
        }else if (ingresoGravable>=4210.42 && ingresoGravable<=7399.42){//*** fila 3
            limiteInferior = 4210.42 ;
            limiteSuperior= 7399.42;
            cuotaFija= 247.24;
            porcentajeSobreExcedente= 0.1088;
        }else if (ingresoGravable>= 7399.43 && ingresoGravable<=8601.5){//*** fila 4
            limiteInferior =  7399.43;
            limiteSuperior=  8601.5;
            cuotaFija=594.21;
            porcentajeSobreExcedente=0.16;
        }else if (ingresoGravable>=8601.51 && ingresoGravable<=10298.35){//*** fila 5
            limiteInferior = 8601.51;
            limiteSuperior= 10298.35;
            cuotaFija= 786.54;
            porcentajeSobreExcedente=0.1792;
        }else if (ingresoGravable>=10298.36 && ingresoGravable<=20770.29){//*** fila 6
            limiteInferior = 10298.36 ;
            limiteSuperior=  20770.29;
            cuotaFija= 1090.61;
            porcentajeSobreExcedente=0.2136;
        }else if (ingresoGravable>=20770.3 && ingresoGravable<=32736.83){//*** fila 7
            limiteInferior = 20770.3;
            limiteSuperior= 32736.83;
            cuotaFija= 3327.42;
            porcentajeSobreExcedente=0.2352;
        }else if (ingresoGravable>=32736.84 && ingresoGravable<=62500){//*** fila 8
            limiteInferior = 32736.84;
            limiteSuperior= 62500;
            cuotaFija=6141.95;
            porcentajeSobreExcedente=0.3;
        }else if (ingresoGravable>=62500.01 && ingresoGravable<=83333.33){//*** fila 9
            limiteInferior =62500.01  ;
            limiteSuperior= 83333.33;
            cuotaFija= 15070.9;
            porcentajeSobreExcedente=0.32;
        }else if (ingresoGravable>=83333.34 && ingresoGravable<=250000){//*** fila 10
            limiteInferior =83333.34  ;
            limiteSuperior=250000;
            cuotaFija= 21737.57;
            porcentajeSobreExcedente=0.34;
        }else if (ingresoGravable>= 250000.01 ){//*** fila 11
            limiteInferior = 250000.01;
            limiteSuperior= Double.MAX_VALUE ;
            cuotaFija=78404.23;
            porcentajeSobreExcedente= 0.35;
        }

        final double base = ingresoGravable - limiteInferior;
        final double subtotal = base * porcentajeSobreExcedente;
        final double ISR = subtotal + cuotaFija;
        double ISR2 = ingresoGravable*.10;
        return ISR;
    }
}
