package conversiones;

public class ToFar {
	//°F = 9.0 / 5.0 * C + 32
	
    public static float centToFahr(float tempOriginal /*Cel*/) {
    	float f;
        f = 9.0f / 5.0f * (tempOriginal + 32);
        return f;
    }
}
