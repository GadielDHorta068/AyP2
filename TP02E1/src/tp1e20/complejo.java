package tp1e20;

public class complejo {
	private double real;
	private double imaginario;
	
	//creo el constructor y los parametros
	public complejo(double real, double imaginario) {
		this.real = real;
		this.imaginario = imaginario;
	}
	public complejo() {
	    this.real = 0.0;
	    this.imaginario = 0.0;
	}

	//Seters y getters
	public double getReal(){
		return real;
	}
	public double getImaginario() {
		return imaginario;
	}
	
	public void setReal(double real) {
		this.real = real;
	}
	
	public void setImagen(double imaginario) {
		this.imaginario = imaginario;
	}
	
	@Override
	public String toString() {
		return "(" + real + ", " + imaginario + ")";
	}
    public complejo multiplicar(double x) {
        complejo aux = new complejo();
        aux.real = this.real * x;
        aux.imaginario = this.imaginario * x;
        return aux;
    }

    // Método dividir con otro número complejo
    public complejo dividir(complejo x) {
        complejo aux = new complejo();
        aux.real = (this.real * x.real + this.imaginario * x.imaginario) / (x.real * x.real + x.imaginario * x.imaginario);
        aux.imaginario = (this.imaginario * x.real - this.real * x.imaginario) / (x.real * x.real + x.imaginario * x.imaginario);
        return aux;
    }

    // Método sumar otro número complejo
    public complejo suma(complejo x) {
        complejo aux = new complejo();
        aux.real = this.real + x.real;
        aux.imaginario = this.imaginario + x.imaginario;
        return aux;
    }

    // Método restar otro número complejo
    public complejo resta(complejo x) {
        complejo aux = new complejo();
        aux.real = this.real - x.real;
        aux.imaginario = this.imaginario - x.imaginario;
        return aux;
    }
}

