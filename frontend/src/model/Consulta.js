class Consulta{

    static instancia;

    documentoCarrefour;
	fecha;
	numeroCaja;
	documentoMedioPago;
	codigoTienda;
	codigoTransaccion;
	codigoEAN;
	tipoMedioPago;

    static instanciar(){
        if(!this.instancia)
            this.instancia = new Consulta();
        return this.instancia;
    }

    //Ordenado según creación de variable
    setConsulta(dC,f,nC,dM,cShop,cTnx,cEAN,tM){
        this.documentoCarrefour = dC;
        this.fecha = f;
        this.numeroCaja = nC;
        this.documentoMedioPago= dM;
        this.codigoTienda = cShop;
        this.codigoTransaccion = cTnx;
        this.codigoEAN = cEAN;
        this.tipoMedioPago = tM;
    }

    getTienda(){
        console.log("La tienda desde consulta es: " + this.codigoTienda);
        return this.codigoTienda;
    }

}
export default Consulta;