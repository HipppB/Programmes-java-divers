
import java.io.IOException;
import java.util.Arrays;


public class Polynomial {
    String polynomial;
    float[][] factors;
     public Polynomial(String polynomial) {
        setPolynomial(polynomial);
        try {
            this.factors = getPolynomialFactors(this.polynomial);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

     }
    public void getPolynomial() {
        System.out.println(this.polynomial);
    }
    public void setPolynomial(String polynomial) {
        this.polynomial = polynomial;
    }
    public float compute(float x) {
        float result = 0f;
        for (int i = 0; i < this.factors.length; i++) {
            result += this.factors[i][0] * Math.pow(x, this.factors[i][1]);
        }
        //System.out.println(this.polynomial.replace("x", (String.valueOf(x))) + " = " + result);
        return result;
    }
    public float findRoot(float inter_start, float inter_end) throws IOException {
        int maxTries = 100;
        float tolerance = 0.02f;
        float middle = 0;
        while (maxTries > 0) {
            middle = (inter_start+inter_end)/2;
            if(compute(middle) == 0 || (inter_end - inter_start) / 2 < tolerance) {
                System.out.println("RESULT " + middle);
                return middle;
            }
            if (compute(middle) < 0 && compute(inter_end) > 0 || compute(middle) > 0 && compute(inter_end) < 0) {
                inter_start = middle;
            } else if (compute(middle) < 0 && compute(inter_start) > 0 || compute(middle) > 0 && compute(inter_start) < 0){
                inter_end = middle;
            } else {
                throw new IOException("Cannot find any root between this interval (with this method).");
            }
            maxTries -= 1;
        }
        throw new IOException("No root precise enough found in this interval");
    }

    private float[][] getPolynomialFactors(String polynomial) {
        polynomial = polynomial.replace("-", "+-");
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

        return terms;
    }
    private boolean isAPositive(){ //To
        return true;
    }

}
