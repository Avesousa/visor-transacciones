class MediosDePago{

    static instancia;

    medios;
    bandera;

        
    static instanciar(){
        if(!this.instancia)
            this.instancia = new MediosDePago();
        return this.instancia;
    }

    //Ordenado según creación de variable
    setMediosDePago(medios){
        this.medios = medios;
        this.bandera = true;
    }

    getMediosDePago(){
        return this.medios;
    }

    getBandera(){
        return this.bandera;
    }

}
export default MediosDePago;