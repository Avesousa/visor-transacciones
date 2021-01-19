class Detalle{

    static instancia;
    detalle;

    static instanciar(){
        if(!this.instancia)
            this.instancia = new Detalle();
        return this.instancia;
    }

    setDetalle(detalle){
        this.detalle = detalle;
    }

    getDetalle(){
        return this.detalle;
    }

}
export default Detalle;