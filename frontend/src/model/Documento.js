class Documento{

    static instancia;
    documento;

    static instanciar(){
        if(!this.instancia)
            this.instancia = new Documento();
        return this.instancia;
    }

    setDocumento(documento){
        this.documento = "data:application/pdf;base64," + documento;
    }

    getDocumento(){
        return this.documento;
    }

}
export default Documento;