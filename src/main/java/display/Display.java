package display;

import controller.Input;
import game.state.State;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Display {
    private Canvas canvas;
    private Renderer renderer;
    private JFrame window;

    public Display(Input input){
        window = new JFrame();
        window.setTitle("RiverRaid");
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);

        renderer = new Renderer();

        canvas = new Canvas();
        canvas.setPreferredSize(Constants.SCREEN_SIZE);
        canvas.setFocusable(false);

        window.add(canvas);
        window.addKeyListener(input);
        window.pack();

        canvas.createBufferStrategy(2);

        window.setVisible(true);
    }

    public void render(State state){
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        renderer.render(state, graphics);

        graphics.dispose();
        bufferStrategy.show();
    }
}
