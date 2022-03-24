
import java.util.Arrays;


public class Polynomial {
    String polynomial;
    public Polynomial(String polynomial) {
        setPolynomial(polynomial);
    }
    public void getPolynomial() {
        System.out.println(this.polynomial);
    }
    public void setPolynomial(String polynomial) {
        this.polynomial = polynomial;
    }
    public float compute(float x) {
        float[][] factors = getPolynomialFactors(this.polynomial);
        float result = 0f;
        for (int i = 0; i < factors.length; i++) {
            result += factors[i][0] * Math.pow(x, factors[i][1]);
        }
        System.out.println(this.polynomial.replace("x", (String.valueOf(x))) + " = " + result);
        return 0f;
    }
    private float[][] getPolynomialFactors(String polynomial) {
        String[] arrayOfStr = polynomial.split("\\+"); // We separate the different terms
        // Our goal is to obtain a double array of floats in the form [ [factor, power], [factor2, power2] ...]
        // The main array will be the same length as arrayOfStr and each sub array of length 2
        float[][] terms = new float[arrayOfStr.length][2];
        // we assign the values in the array, if no values for the factor or power = 1 if no values for the x => power = 0
        for (int i = 0; i < arrayOfStr.length; i++) {
            String component = arrayOfStr[i];
            float[] tempTerms = new float[2];
            // We separate both parts :
            String[] parts = component.split("x");
            //Typical cases
            for(String element : parts) {

                if(element.contains(".")) {
                    tempTerms[0] = Float.parseFloat(element.replace(".", ""));
                }
                if(element.contains("^")) {
                    tempTerms[1] = Float.parseFloat(element.replace("^", ""));
                }
            }
            //Special Cases
            if(!component.contains(".")) {
                tempTerms[0] = 1;
            }
            if(!component.contains("x")) {
                tempTerms[0] = Float.parseFloat(parts[0]);
                tempTerms[1] = 0;
            }
            if(component.contains("x") && !component.contains("^")) {
                tempTerms[1] = 1;
            }
            terms[i][0] = tempTerms[0];
            terms[i][1] = tempTerms[1];

        }
        //System.out.println(polynomial + " was transormed to :" ); //Checking
        //for (float[] term: terms) {
        //    System.out.println(Arrays.toString(term));
        //}
        return terms;
    }


}
