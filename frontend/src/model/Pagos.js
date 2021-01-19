class Pagos{

    static instancia;
    pagos;

    static instanciar(){
        if(!this.instancia)
            this.instancia = new Pagos();
        return this.instancia;
    }

    setPagos(pagos){
        this.pagos = pagos;
    }

    getPagos(){
        return this.pagos;
    }

}
export default Pagos