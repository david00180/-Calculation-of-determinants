
public class Det_Clac {
	public static void main(String[] args) {

		double[][] a = { { 1.2, 2, 3, 3, 5, 1, 10 }, { 4, 5, 6, 6, 65, 1, 4 }, { 7, 8, 10, 2, 3, 1, 3 },
				{ 1, 2, 3, 4, -4, 4, 10 }, { 2, 3, 4, 3, 3, 3, 9 }, { 2, 3, -12, 1, 2, 30, 3 },
				{ 7, 5, 9, 10, 2, 4, 3 } };

		double[][] a2 = {{1,2},{2,3}};
		
		System.out.println(detCalc(a2));

	}

	public static double detCalc(double[][] a) {
		if(a.length == 2) {
			return det2x2(a);
		}
		double[][] tempA = new double[a.length - 1][a.length - 1];

		double temp1 = 0, temp2 = 1;
		for (int i = 0; i < a.length; i++) {
			for (int t = 1, z = 0; t < a.length; t++, z++) {
				for (int j = 0, h = 0; j < a.length; j++) {
					if (j != i) {
						tempA[z][h] = a[t][j];
						h++;
					} // if
				} // j loop
			} // t loop

			if (tempA.length == 2) {
				temp2 = a[0][i];
				if (i % 2 == 0) {
					temp1 += temp2 * det2x2(tempA);
				} else {
					temp1 -= temp2 * det2x2(tempA);
				}

			} else {
				temp2 = a[0][i];
				if (i % 2 == 0) {
					temp1 += temp2 * detCalc(tempA);
				} else {
					temp1 -= temp2 * detCalc(tempA);
				}
			}

		} // i loop

		return temp1;

	}
	public static double det2x2(double[][] a) {
		return a[0][0] * a[1][1] - a[0][1] * a[1][0];
	}
}
