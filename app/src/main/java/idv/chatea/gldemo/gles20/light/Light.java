package idv.chatea.gldemo.gles20.light;

public class Light {
    /**
     * x, y, z, w. if W = 0, it is direction light, otherwise it is position light.
     */
    public float[] position = new float[4];

    public float[] ambientChannel = new float[4];
    public float[] diffusionChannel = new float[4];
    public float[] specularChannle = new float[4];

    // TODO geometric diffusion channel and specular channel
}