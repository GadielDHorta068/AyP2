package conversiones;

public class ToCent {
	//C = 5.0 / 9.0 * (F - 32)

	public static float fahrToCent(float tempOriginal) {
        float c;
        c = 5.0f / 9.0f * (tempOriginal - 32);
        return c;
	}
}
