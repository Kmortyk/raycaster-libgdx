package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Map {
    protected int size;
    protected int[] wallGrid;
    protected double light;
    protected Texture skybox;
    protected Texture wallTexture;

    public Map(int size) {
        this.size = size;
        this.wallGrid = new int[this.size * this.size];
        this.light = 0;
        this.skybox = new Texture(Gdx.files.internal("deathvalley_panorama.jpg"));
        this.wallTexture = new Texture(Gdx.files.internal("wall_texture.jpg"));
    }

    public Integer get(double x, double y) {
        x = Math.floor(x);
        y = Math.floor(y);
        if (x < 0 || x > this.size - 1 || y < 0 || y > this.size - 1) return -1;
        return this.wallGrid[(int)(y * this.size + x)];
    }

    public void randomize() {
        for (int i = 0; i < this.size * this.size; i++) {
            this.wallGrid[i] = Math.random() < 0.3 ? 1 : 0;
        }
    }

}