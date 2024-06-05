package conversorApi;

public class Conversor {
    private String baseCode;
    private String targetCode;
    private  double conversionResult;
    private double conversionRate;
    private double valor;

    public Conversor(String baseCode, String targetCode, double valor){
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.valor = valor;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Conversor {" +
                "baseCode = '" + baseCode + '\'' +
                ", targetCode = '" + targetCode + '\'' +
                ", conversionResult = " + conversionResult +
                ", conversionRate = " + conversionRate +
                '}';
    }
}
