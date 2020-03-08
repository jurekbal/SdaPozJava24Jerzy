package zajecia10.ksztalty;

public class Triangle extends Polygon {
        double[] bases = new double[3];
    //    private double baseA;
//    private double baseB;
//    private double baseC;
//    //private double heightA;

    public Triangle(double baseA, double baseB, double baseC) throws InvalidTriangleException {
        this.bases[0] = baseA;
        this.bases[1] = baseB;
        this.bases[2] = baseC;
        if (!isValid()) {
            throw new InvalidTriangleException("Z tych boków nie da się zbudoawć trójkąta!");
        }
    }

    private boolean isValid() {
        double longestBase = bases[0];
        int longestBaseIndex = 0;
        for (int i = 1; i < bases.length; i++) {
            if (bases[i] > longestBase) {
                longestBase = bases[i];
                longestBaseIndex = i;
            }
        }
        int twoBasesSum = 0;
        for (int i = 0; i < bases.length; i++) {
            if (i != longestBaseIndex) {
                twoBasesSum+= bases[i];
            }
        }
        return (longestBase < twoBasesSum);
    }


    @Override
    public int getEdgesNum() {
        return 3;
    }

    @Override
    public double getArea() {
        return Math.sqrt(bases[0]+bases[1]+bases[2])*(bases[0]+bases[1]-bases[2])*
                (bases[0]-bases[1]+bases[2]*(-bases[0]+bases[1]+bases[2])) / 4;
        //return 0.5 * baseA * heightA;
    }

    @Override
    public double getPerimrter() {
        return bases[0] + bases[1] + bases[2];
    }
}
