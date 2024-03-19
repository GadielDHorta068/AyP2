package conversiones;

public class ToFar {
	//°F = 9.0 / 5.0 * C + 32
	
    public static float CentToFahr(float tempOriginal /*Cel*/) {
    	float F;
        F = 9.0f / 5.0f * (tempOriginal + 32);
        return F;
    }
}
