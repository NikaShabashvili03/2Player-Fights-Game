import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameField extends JPanel{
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        Main.onRepaint(g);
        Player1 player = new Player1();
        if(player.getDefenseTime() < 101){
            player.setDefenseTime(player.getDefenseTime() + 0.02);
        }
        Enemy enemy = new Enemy();
        if(enemy.getDefenseTime() < 101){
            enemy.setDefenseTime(enemy.getDefenseTime() + 0.02);
        }
        if(!player.isDefense()){
            if(player.isLeft()){
                if (player.getPx() > 0) {
//                    if ((int)player.getPx() != (int)enemy.getPx() + 60) {
                        player.setPx(player.getPx() - player.getSpeed());
//                    }
                    if((int)player.getPx() < (int)enemy.getPx()){
                        player.setFocusSide(true);
                        enemy.setFocusSide(false);
                    }
                }
            }
            if(player.isRight()){
                if (player.getPx() < 1000 - 100) {
//                    if ((int)player.getPx() != (int)enemy.getPx() - 60) {
                        player.setPx(player.getPx() + player.getSpeed());
//                    }
                    if((int)player.getPx() > (int)enemy.getPx()){
                        player.setFocusSide(false);
                        enemy.setFocusSide(true);
                    }
                }
            }
        }
        if(player.isDefense()){
            player.setDefenseTime(player.getDefenseTime() - 0.10);
            if(player.getDefenseTime() <= 0){
                try {
                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[1])));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                player.setDefense(false);
            }
        }
        if(!enemy.isDefense()) {
            if (enemy.isLeft()) {
                if (enemy.getPx() > 0) {
//                    if ((int)enemy.getPx() != (int)player.getPx() + 60) {
                        enemy.setPx(enemy.getPx() - enemy.getSpeed());
//                    }
                      if((int)enemy.getPx() < (int)player.getPx()){
                          enemy.setFocusSide(true);
                          player.setFocusSide(false);
                      }
                }
            }
            if (enemy.isRight()) {
                if (enemy.getPx() < 1000 - 100) {
//                    if ((int)enemy.getPx() != (int)player.getPx() - 60) {
                        enemy.setPx(enemy.getPx() + enemy.getSpeed());
//                    }
                    if((int)enemy.getPx() > (int)player.getPx()){
                        enemy.setFocusSide(false);
                        player.setFocusSide(true);
                    }
                }
            }
        }
        if(enemy.isDefense()){
            enemy.setDefenseTime(enemy.getDefenseTime() - 0.10);
            if(enemy.getDefenseTime() <= 0){
                try {
                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[2])));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                enemy.setDefense(false);
            }
        }
        if(!player.isAttack()){
            if(player.isFocusSide()){
                player.setPlayerDamageEffectX(player.getPx());
            }
            if(!player.isFocusSide()){
                player.setPlayerDamageEffectX(player.getPx()-100);
            }
        }
        if(!enemy.isAttack()){
            if(enemy.isFocusSide()){
                enemy.setPlayerDamageEffectX(enemy.getPx());
            }
            if(!enemy.isFocusSide()){
                enemy.setPlayerDamageEffectX(enemy.getPx()-100);
            }
        }
        repaint();
    }
    public void playerAttack(){
        Player1 player = new Player1();
        Enemy enemy = new Enemy();
        if(player.isFocusSide()){
            if(!player.isDefense()) {
                // SICOCXLIS DAKLEBA -------
                if(!enemy.isDefense()){
                    if((int)player.getPx()+100+player.getRange() > (int)enemy.getPx()+5){
                        enemy.setHealth(enemy.getHealth() - player.getDamage());
                        if(enemy.getHealth() <= 2){
                            player.setWin(true);
                        }
                    }
                }
            }
        }
        if(!player.isFocusSide()){
            if(!player.isDefense()) {
                // SICOCXLIS DAKLEBA -------
                if(player.isAttack()){
                    if(!enemy.isDefense()){
                        if ((int) player.getPx() - player.getRange() < (int) enemy.getPx() + 95) {
                            enemy.setHealth(enemy.getHealth() - player.getDamage());
                            if(enemy.getHealth() <= 2){
                                player.setWin(true);
                            }
                        }
                    }
                }
            }
        }
        setTimeout(() -> {
            player.setAttack(false);
            if(player.isFocusSide()){
                try {
                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[1])));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(!player.isFocusSide()){
                try {
                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[2])));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            setTimeout(() -> {
                player.setAttackTimer(true);
            },100);
        }, (int)player.getAttackSpeed());

    }
    public void enemyAttack(){
        Player1 player = new Player1();
        Enemy enemy = new Enemy();
        if(!enemy.isFocusSide()){
            if(!enemy.isDefense()) {
                // SICOCXLIS DAKLEBA -------
                if(enemy.isAttack()){
                    if (!player.isDefense()) {
                        if ((int) enemy.getPx() - enemy.getRange() < (int) player.getPx() + 95) {
                            player.setHealth(player.getHealth() - enemy.getDamage());
                            if (player.getHealth() <= 2) {
                                enemy.setWin(true);
                            }
                        }
                    }
                }
            }
        }
        if(enemy.isFocusSide()){
            if(!enemy.isDefense()) {
                // SICOCXLIS DAKLEBA -------
                if (!player.isDefense()) {
                    if((int)enemy.getPx()+100+player.getRange() > (int)player.getPx()+5){
                        player.setHealth(player.getHealth() - enemy.getDamage());
                        if (player.getHealth() <= 2) {
                            enemy.setWin(true);
                        }
                    }
                }
            }
        }
        setTimeout(() -> {
            enemy.setAttack(false);
            if(!enemy.isFocusSide()){
                try {
                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[2])));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(enemy.isFocusSide()){
                try {
                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[1])));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            setTimeout(() -> {
                enemy.setAttackTimer(true);
            },100);
        }, (int)enemy.getAttackSpeed());
    }
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
}