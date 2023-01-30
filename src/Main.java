import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Main extends JFrame{
    private static Main game;

    private static Image Arrow;
    private static Image Ready;
    private static Image Background;
    private static Image Fontground;
    // Player
    private static boolean playerChose = true;
    private static boolean pChoseHero = false;

    //Enemy
    private static boolean enemyChose = false;
    private static boolean eChoseHero = false;

    // Player and Enemy
    private static Image Refresh;
    private static int refreshX = 440;
    private static int refreshY = 400;

    private static int readyX = 440;
    private static int readyY = 400;
    //PIGMAN
    private static String[] Pigman = {"Pigman","/Images/Rpigman.png","/Images/Lpigman.png","/Images/PigDefense.png","Images/RpigmanAttack.png","/Images/LpigmanAttack.png","/Images/LpigmanEffect.png","/Images/RpigmanEffect.png"};
    private static int pigmanIconX = 300;
    private static int pigmanIconY = 250;
    private static double pigmanSpeed = 0.18;
    private static double pigmanAttackSpeed = 600;
    private  static int pigmanDamage = 15;
    private static int pigmanRange = 250;
    private static int pigmanEffectWidth = 50;

    private static Image pigmanImage;
    //GHOST
    //                                 0                1                  2                      4||
    private static String[] Ghost = {"Ghost","/Images/Rghost.png","/Images/Lghost.png","/Images/Gdefense.png","/Images/RghostAttack.png","/Images/LghostAttack.png","/Images/LghostEffect.png","/Images/RghostEffect.png"};
    private static int ghostIconX = 300;
    private static int ghostIconY = 100;
    private static double ghostSpeed = 0.5;
    private static double ghostAttackSpeed = 180;
    private static int ghostDamage = 12;
    private static int ghostEffectWidth = 10;
    private static int ghostRange = 60;
    private static Image ghostImage;
    //
    //SKELETON
    //                                        0                1                  2       ||
    private static String[] Skeleton = {"Skeleton","/Images/Rskeleton.png","/Images/Lskeleton.png","/Images/Sdefense.png","/Images/RskeletonAttack.png","/Images/LskeletonAttack.png","/Images/LskeletonEffect.png","/Images/RskeletonEffect.png"};
    private static int skeletonIconX = 450;
    private static int skeletonIconY = 100;
    private static double skeletonSpeed = 0.2;
    private static int skeletonRange = 50;

    private static double skeletonAttackSpeed = 250;
    private static int skeletonDamage = 14;
    private static int skeletonEffectWidth = 10;
    private static Image skeletonImage;

    //Person
    //                                   0                1                  2       ||
    private static String[] Person = {"Person","/Images/Rperson.png","/Images/Lperson.png","/Images/Pdefense.png","/Images/RpersonAttack.png","/Images/LpersonAttack.png","/Images/LpersonEffect.png","/Images/RpersonEffect.png"};
    private static int personIconX = 600;
    private static int personIconY = 100;
    private static double personSpeed = 0.2;
    private static int personDamage = 13;
    private static double personAttackSpeed = 230;
    private static int personRange = 40;
    private static int personEffectWidth = 7;
    private static Image personImage;
    public static void main(String[] args) throws IOException {
        game = new Main();
        Arrow = ImageIO.read(Main.class.getResourceAsStream("/Images/arrow.png"));
        Ready = ImageIO.read(Main.class.getResourceAsStream("/Images/ready.png"));
        Background = ImageIO.read(Main.class.getResourceAsStream("/Images/background.png"));
        Fontground = ImageIO.read(Main.class.getResourceAsStream("/Images/fontground.png"));
        Refresh = ImageIO.read(Main.class.getResourceAsStream("/Images/resetGame.png"));
        ghostImage = ImageIO.read(Main.class.getResourceAsStream(Ghost[1]));
        skeletonImage = ImageIO.read(Main.class.getResourceAsStream(Skeleton[1]));
        personImage = ImageIO.read(Main.class.getResourceAsStream(Person[1]));
        pigmanImage = ImageIO.read(Main.class.getResourceAsStream(Pigman[1]));
        game.setSize(1000,500);
        game.setResizable(false);
        game.setTitle("g");
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.setLocation(200,150);
        GameField gameF = new GameField();
        game.add(gameF);
        game.setVisible(true);
        Player1 player = new Player1();
        game.addKeyListener(new KeyAdapter() {
            Player1 player = new Player1();
            Enemy enemy = new Enemy();

            @Override
            public void keyReleased(KeyEvent e) {
                if(!playerChose && !enemyChose){
                    if(!player.isWin() && !enemy.isWin()){
                        if (e.getKeyCode() == KeyEvent.VK_A) player.setLeft(false);
                        if (e.getKeyCode() == KeyEvent.VK_D) player.setRight(false);
                        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                        };
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) enemy.setLeft(false);
                        if (e.getKeyCode() == KeyEvent.VK_RIGHT) enemy.setRight(false);
                        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {

                        };
                    }
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(!playerChose && !enemyChose){
                    if(!player.isWin() && !enemy.isWin()) {
                        if (e.getKeyCode() == KeyEvent.VK_A) {
                            player.setLeft(true);
                            if(player.isFocusSide()){
                                try {
                                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[1])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(!player.isFocusSide()){
                                try {
                                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[2])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(enemy.isFocusSide()){
                                try {
                                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[1])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(!enemy.isFocusSide()){
                                try {
                                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[2])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        };
                        if (e.getKeyCode() == KeyEvent.VK_D) {
                            player.setRight(true);
                            if(player.isFocusSide()){
                                try {
                                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[1])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(!player.isFocusSide()){
                                try {
                                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[2])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(enemy.isFocusSide()){
                                try {
                                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[1])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(!enemy.isFocusSide()){
                                try {
                                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[2])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        };
                        if (player.isAttackTimer() && !player.isAttack() && !player.isDefense()) {
                            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                                player.setAttackTimer(false);
                                player.setAttack(true);
                                if (!player.isFocusSide()) {
                                    try {
                                        player.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[6])));
                                        player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[5])));
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                if (player.isFocusSide()) {
                                    try {
                                        player.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[7])));
                                        player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[4])));
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                gameF.playerAttack();
                            }
                        }
                        if (player.getDefenseTime() >= 100) {
                            if (e.getKeyCode() == KeyEvent.VK_S) {
                                try {
                                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[3])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                player.setDefense(true);
                            }
                            ;
                        }
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                            enemy.setLeft(true);
                            if(player.isFocusSide()){
                                try {
                                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[1])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(!player.isFocusSide()){
                                try {
                                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[2])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(enemy.isFocusSide()){
                                try {
                                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[1])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(!enemy.isFocusSide()){
                                try {
                                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[2])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        };
                        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                            enemy.setRight(true);
                            if(player.isFocusSide()){
                                try {
                                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[1])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(!player.isFocusSide()){
                                try {
                                    player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[2])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(enemy.isFocusSide()){
                                try {
                                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[1])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            if(!enemy.isFocusSide()){
                                try {
                                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[2])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        };
                        if (enemy.isAttackTimer() && !enemy.isDefense() && !enemy.isAttack()) {
                            if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                                enemy.setAttack(true);
                                enemy.setAttackTimer(false);
                                if(!enemy.isFocusSide()){
                                    try {
                                        enemy.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[6])));
                                        enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[5])));
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                if(enemy.isFocusSide()){
                                    try {
                                        enemy.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[7])));
                                        enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[4])));
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                gameF.enemyAttack();
                            }
                        }
                        if (enemy.getDefenseTime() >= 100) {
                            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                try {
                                    enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[3])));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                enemy.setDefense(true);
                            }
                        }
                    }
                }
            }
        });
        game.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Player1 player = new Player1();
                Enemy enemy = new Enemy();
                int mx = e.getX();
                int my = e.getY();

                float ready_x_left = readyX + 100;
                float ready_y_bottom = readyY + 50;

                float refresh_x_left = refreshX + 100;
                float refresh_y_bottom = refreshY + 50;

                float choseGhost_x_left = ghostIconX + 100;
                float choseGhost_y_bottom = ghostIconY + 100;

                float choseSkeleton_x_left = skeletonIconX + 100;
                float choseSkeleton_y_bottom = skeletonIconY + 100;

                float chosePigman_x_left = pigmanIconX + 100;
                float chosePigman_y_bottom = pigmanIconY + 100;

                float chosePerson_x_left = personIconX + 100;
                float chosePerson_y_bottom = personIconY + 100;
                if(player.isWin() || enemy.isWin()){
                    if(mx >= refreshX && mx <= refresh_x_left && my >= refreshY && my <= refresh_y_bottom){
                        //Player Reset
                        player.setPx(0);
                        player.setHealth(200);
                        player.setWin(false);
                        player.setSpeed(0);
                        player.setDamage(0);
                        player.setLeft(false);
                        player.setRight(false);
                        player.setRange(0);
                        player.setAttackSpeed(0);
                        player.setFocusSide(true);

                        //Enemy Reset
                        enemy.setPx(900);
                        enemy.setHealth(200);
                        enemy.setWin(false);
                        enemy.setSpeed(0);
                        enemy.setDamage(0);
                        enemy.setLeft(false);
                        enemy.setRight(false);
                        enemy.setRange(0);
                        enemy.setAttackSpeed(0);
                        enemy.setFocusSide(false);
                        //
                        playerChose = true;
                    }
                }
                if(mx >= pigmanIconX && mx <= chosePigman_x_left && my >= pigmanIconY && my <= chosePigman_y_bottom){
                    try {
                        if(playerChose){
                            player.setPlayerIcon(Pigman);
                            player.setSkin(1);
                            player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[player.getSkin()])));
                            player.setSpeed(pigmanSpeed);
                            player.setDamage(pigmanDamage);
                            player.setRange(pigmanRange);
                            player.setAttackSpeed(pigmanAttackSpeed);


                            player.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[7])));
                            player.setPlayerDamageEffectX(player.getPx());
                            player.setPlayerDamageEffectWidth(pigmanEffectWidth);
                            player.setPlayerDamageEffectHeight(100);
                            pChoseHero = true;
                        }
                        if(enemyChose){
                            enemy.setPlayerIcon(Pigman);
                            enemy.setSkin(2);
                            enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[enemy.getSkin()])));
                            enemy.setSpeed(pigmanSpeed);
                            enemy.setDamage(pigmanDamage);
                            enemy.setRange(pigmanRange);
                            enemy.setAttackSpeed(pigmanAttackSpeed);

                            enemy.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[6])));
                            enemy.setPlayerDamageEffectX(player.getPx()-100);
                            enemy.setPlayerDamageEffectWidth(pigmanEffectWidth);
                            enemy.setPlayerDamageEffectHeight(100);
                            eChoseHero = true;
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if(mx >= ghostIconX && mx <= choseGhost_x_left && my >= ghostIconY && my <= choseGhost_y_bottom){
                    try {
                        if(playerChose){
                            player.setPlayerIcon(Ghost);
                            player.setSkin(1);
                            player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[player.getSkin()])));
                            player.setSpeed(ghostSpeed);
                            player.setDamage(ghostDamage);
                            player.setRange(ghostRange);
                            player.setAttackSpeed(ghostAttackSpeed);

                            player.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[7])));
                            player.setPlayerDamageEffectX(player.getPx());
                            player.setPlayerDamageEffectWidth(ghostEffectWidth);
                            player.setPlayerDamageEffectHeight(100);
                            pChoseHero = true;
                        }
                        if(enemyChose){
                            enemy.setPlayerIcon(Ghost);
                            enemy.setSkin(2);
                            enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[enemy.getSkin()])));
                            enemy.setSpeed(ghostSpeed);
                            enemy.setDamage(ghostDamage);
                            enemy.setRange(ghostRange);
                            enemy.setAttackSpeed(ghostAttackSpeed);

                            enemy.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[6])));
                            enemy.setPlayerDamageEffectX(player.getPx()-100);
                            enemy.setPlayerDamageEffectWidth(ghostEffectWidth);
                            enemy.setPlayerDamageEffectHeight(100);
                            eChoseHero = true;
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if(mx >= skeletonIconX && mx <= choseSkeleton_x_left && my >= skeletonIconY && my <= choseSkeleton_y_bottom){
                    try {
                        if(playerChose) {
                            player.setPlayerIcon(Skeleton);
                            player.setSkin(1);
                            player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[player.getSkin()])));
                            player.setSpeed(skeletonSpeed);
                            player.setDamage(skeletonDamage);
                            player.setRange(skeletonRange);
                            player.setAttackSpeed(skeletonAttackSpeed);


                            player.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[7])));
                            player.setPlayerDamageEffectX(player.getPx());
                            player.setPlayerDamageEffectWidth(skeletonEffectWidth);
                            player.setPlayerDamageEffectHeight(100);
                            pChoseHero = true;
                        }
                        if(enemyChose) {
                            enemy.setPlayerIcon(Skeleton);
                            enemy.setSkin(2);
                            enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[enemy.getSkin()])));
                            enemy.setSpeed(skeletonSpeed);
                            enemy.setDamage(skeletonDamage);
                            enemy.setRange(skeletonRange);
                            enemy.setAttackSpeed(skeletonAttackSpeed);


                            enemy.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[6])));
                            enemy.setPlayerDamageEffectX(player.getPx()-100);
                            enemy.setPlayerDamageEffectWidth(skeletonEffectWidth);
                            enemy.setPlayerDamageEffectHeight(100);
                            eChoseHero = true;
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if(mx >= personIconX && mx <= chosePerson_x_left && my >= personIconY && my <= chosePerson_y_bottom){
                    try {
                        if(playerChose) {
                            player.setPlayerIcon(Person);
                            player.setSkin(1);
                            player.setPlayer(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[player.getSkin()])));
                            player.setSpeed(personSpeed);
                            player.setDamage(personDamage);
                            player.setRange(personRange);
                            player.setAttackSpeed(personAttackSpeed);


                            player.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(player.getPlayerIcon()[7])));
                            player.setPlayerDamageEffectX(player.getPx());
                            player.setPlayerDamageEffectWidth(personEffectWidth);
                            player.setPlayerDamageEffectHeight(100);
                            pChoseHero = true;
                        }
                        if(enemyChose){
                            enemy.setPlayerIcon(Person);
                            enemy.setSkin(2);
                            enemy.setPlayer(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[enemy.getSkin()])));
                            enemy.setSpeed(personSpeed);
                            enemy.setDamage(personDamage);
                            enemy.setRange(personRange);
                            enemy.setAttackSpeed(personAttackSpeed);


                            enemy.setPlayerDamageEffect(ImageIO.read(Main.class.getResourceAsStream(enemy.getPlayerIcon()[6])));
                            enemy.setPlayerDamageEffectX(player.getPx()-100);
                            enemy.setPlayerDamageEffectWidth(personEffectWidth);
                            enemy.setPlayerDamageEffectHeight(100);
                            eChoseHero = true;
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if(pChoseHero){
                    if(mx >= readyX && mx <= ready_x_left && my >= readyY && my <= ready_y_bottom){
                        playerChose = false;
                        enemyChose = true;
                        pChoseHero = false;
                    }
                }
                if(eChoseHero){
                    if(mx >= readyX && mx <= ready_x_left && my >= readyY && my <= ready_y_bottom){
                        playerChose = false;
                        enemyChose = false;
                        eChoseHero = false;
                    }
                }
            }
        });
    }


    public static void onRepaint (Graphics g){
        g.drawImage(Background,0,0,1000,500,null);
        Player1 player = new Player1();
        Enemy enemy = new Enemy();

        // Player
        if(player.isFocusSide()){
            g.setColor(Color.white);
            g.drawString(player.getPlayerIcon()[0],215,22);
            g.drawImage(player.getPlayer(),(int)player.getPx(),player.getPy(),100,200,null);
            g.setColor(Color.white);
            g.drawRect(5,35,100+1, 15);
            g.setColor(Color.blue);
            g.fillRect(5,35,(int)player.getDefenseTime(),15);
//            g.setColor(Color.red);
//            g.fillRect((int)player.getPx(),player.getPy(),100,200);

            g.setColor(Color.white);
            g.drawRect(5,10,200+1, 20);
            g.setColor(Color.red);
            g.fillRect(5,10,(int)player.getHealth(),20);
//            g.drawRect((int)player.getPx()+100,200,player.getRange(),50);

            // ------ ====>>>>>>>>>
            if(player.isAttack()){
                if(player.getPlayerDamageEffectX() < player.getPx() + player.getRange() - player.getPlayerDamageEffectWidth()){
                    player.setPlayerDamageEffectX(player.getPlayerDamageEffectX() + 2);
                }
                if(player.getPlayerDamageEffectX() < enemy.getPx()-80 && player.getPlayerDamageEffectX() < player.getPx() + player.getRange() - player.getPlayerDamageEffectWidth()){
                    g.drawImage(player.getPlayerDamageEffect(),(int)player.getPlayerDamageEffectX()+100, player.getPy()+20, player.getPlayerDamageEffectWidth(),player.getPlayerDamageEffectHeight(),null);
                }
            }
        }
        if(!player.isFocusSide()){
            g.setColor(Color.white);
            g.drawString(player.getPlayerIcon()[0],215,22);
            g.drawImage(player.getPlayer(),(int)player.getPx(),player.getPy(),100,200,null);
            g.setColor(Color.white);
            g.drawRect(5,35,100+1, 15);
            g.setColor(Color.blue);
            g.fillRect(5,35,(int)player.getDefenseTime(),15);
//            g.setColor(Color.red);
//            g.fillRect((int)player.getPx(),player.getPy(),100,200);

            g.setColor(Color.white);
            g.drawRect(5,10,200+1, 20);
            g.setColor(Color.red);
            g.fillRect(5,10,(int)player.getHealth(),20);
//            g.drawRect((int)player.getPx()-player.getRange(),200,player.getRange(),50);
            // ------ ====<<<<<<<<<<<<<<<
            if(player.isAttack()){
                g.setColor(Color.CYAN);
//                g.fillRect((int)player.getPx()-player.getRange(),player.getPy()+50,player.getRange(),50);
                if(player.getPlayerDamageEffectX() > player.getPx() - 100 - player.getRange()){
                    player.setPlayerDamageEffectX(player.getPlayerDamageEffectX() - 2);
                }
                if(player.getPlayerDamageEffectX() > enemy.getPx()-80 && player.getPlayerDamageEffectX() > player.getPx() - 100 - player.getRange()){
                    g.drawImage(player.getPlayerDamageEffect(),(int)player.getPlayerDamageEffectX()+100, player.getPy()+20, player.getPlayerDamageEffectWidth(),player.getPlayerDamageEffectHeight(),null);
                }
            }
        }
        // -------
       if (!enemy.isFocusSide()){
           // ENEMY
           g.setColor(Color.white);
           g.drawRect(894,35,100+1, 15);
           g.setColor(Color.blue);
           g.fillRect(894,35,(int)enemy.getDefenseTime(),15);
           g.setColor(Color.white);
           g.drawRect(794,10,200+1, 20);
           g.setColor(Color.red);
           g.fillRect(794,10,(int)enemy.getHealth(),20);

           g.setColor(Color.white);
           g.drawString(enemy.getPlayerIcon()[0],738,22);
           g.drawImage(enemy.getPlayer(),(int)enemy.getPx(),enemy.getPy(),100,200,null);
           //enemy
//           g.setColor(Color.blue);
//           g.fillRect((int)enemy.getPx(),enemy.getPy(),100,200);
//        g.setColor(Color.GREEN);
//        g.drawRect((int)enemy.getPx()-enemy.getRange(),enemy.getPy(),enemy.getRange(),50);
           if(enemy.isAttack()){
               g.setColor(Color.GREEN);
//               g.drawRect((int)enemy.getPx()-enemy.getRange(),player.getPy()+50,enemy.getRange(),50);
               g.setColor(Color.CYAN);
//                g.fillRect((int)player.getPx()-player.getRange(),player.getPy()+50,player.getRange(),50);
               if(enemy.getPlayerDamageEffectX() > enemy.getPx() - 100 - enemy.getRange()){
                   enemy.setPlayerDamageEffectX(enemy.getPlayerDamageEffectX() - 2);
               }
               if(enemy.getPlayerDamageEffectX() > player.getPx()-80 && enemy.getPlayerDamageEffectX() > enemy.getPx() - 100 - enemy.getRange()){
                   g.drawImage(enemy.getPlayerDamageEffect(),(int)enemy.getPlayerDamageEffectX()+100, enemy.getPy()+20, enemy.getPlayerDamageEffectWidth(),enemy.getPlayerDamageEffectHeight(),null);
               }

           }
//           g.drawRect((int)enemy.getPx()-enemy.getRange(),200,enemy.getRange(),50);

       }
        if (enemy.isFocusSide()){
            // ENEMY
            g.setColor(Color.white);
            g.drawRect(894,35,100+1, 15);
            g.setColor(Color.blue);
            g.fillRect(894,35,(int)enemy.getDefenseTime(),15);
            g.setColor(Color.white);
            g.drawRect(794,10,200+1, 20);
            g.setColor(Color.red);
            g.fillRect(794,10,(int)enemy.getHealth(),20);

            g.setColor(Color.white);
            g.drawString(enemy.getPlayerIcon()[0],738,22);
            g.drawImage(enemy.getPlayer(),(int)enemy.getPx(),enemy.getPy(),100,200,null);
            //enemy
//            g.setColor(Color.blue);
//            g.fillRect((int)enemy.getPx(),enemy.getPy(),100,200);
//        g.setColor(Color.GREEN);
//        g.drawRect((int)enemy.getPx()-enemy.getRange(),enemy.getPy(),enemy.getRange(),50);
            if(enemy.isAttack()){
//                g.setColor(Color.CYAN);
//                g.fillRect((int)player.getPx()+100,player.getPy()+50,player.getRange(),50);
                if(enemy.getPlayerDamageEffectX() < enemy.getPx() + enemy.getRange() - enemy.getPlayerDamageEffectWidth()){
                    enemy.setPlayerDamageEffectX(enemy.getPlayerDamageEffectX() + 2);
                }
                if(enemy.getPlayerDamageEffectX() < player.getPx()-80 && enemy.getPlayerDamageEffectX() < enemy.getPx() + enemy.getRange() - enemy.getPlayerDamageEffectWidth()){
                    g.drawImage(enemy.getPlayerDamageEffect(),(int)enemy.getPlayerDamageEffectX()+100, enemy.getPy()+20, enemy.getPlayerDamageEffectWidth(),enemy.getPlayerDamageEffectHeight(),null);
                }
            }
//            g.drawRect((int)enemy.getPx()+100,200,enemy.getRange(),50);

        }
        g.drawImage(Fontground,0,0,1000,500,null);
        if(playerChose || enemyChose) {
            g.setColor(new Color(100,100,100,200));
            g.fillRect(0,0,1000,500);
            g.setColor(Color.black);
            g.drawImage(Ready,readyX, readyY,100,50,null);
            if(playerChose){
                g.drawImage(Arrow,(int)player.getPx()+25,player.getPy()-130,20,50,null);
                g.setColor(Color.WHITE);
                g.drawString("Attack Speed: " + player.getAttackSpeed(),(int)player.getPx()+10,player.getPy() - 5);
                g.drawString("Range: " + player.getRange(),(int)player.getPx()+10, player.getPy() - 20);
                g.drawString("Speed: " + player.getSpeed(),(int)player.getPx()+10,player.getPy() - 35);
                g.drawString("Damage: " + player.getDamage(),(int)player.getPx()+10, player.getPy() - 50);

            }
            if(enemyChose){
                g.drawImage(Arrow,(int)enemy.getPx()+25,enemy.getPy()-130,20,50,null);
                g.setColor(Color.WHITE);
                g.drawString("Attack Speed: " + enemy.getAttackSpeed(),(int)enemy.getPx()-25,enemy.getPy() - 5);
                g.drawString("Range: " + enemy.getRange(),(int)enemy.getPx()+10, enemy.getPy() - 20);
                g.drawString("Speed: " + enemy.getSpeed(),(int)enemy.getPx()+10,enemy.getPy() -35);
                g.drawString("Damage: " + enemy.getDamage(),(int)enemy.getPx()+10,enemy.getPy()-50);
            }
            g.setColor(Color.BLUE);
            g.drawImage(ghostImage,ghostIconX, ghostIconY, 100, 100,new Color(100,100,100,250),null);

            g.setColor(Color.RED);
            g.drawImage(skeletonImage,skeletonIconX, skeletonIconY, 100, 100,new Color(100,100,100,250),null);

            g.setColor(Color.pink);
            g.drawImage(personImage,personIconX, personIconY, 100, 100,new Color(100,100,100,250),null);

            g.setColor(Color.pink);
            g.drawImage(pigmanImage,pigmanIconX, pigmanIconY, 100, 100,new Color(100,100,100,250),null);
        }
        if(player.isWin()){
            g.setColor(new Color(100,100,100,200));
            g.fillRect(0,0,1000,500);
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
            g.drawString(player.getPlayerIcon()[0] + " Win Fight!",350,150);
            g.drawImage(Refresh,refreshX,refreshY,100,50,null);
            player.setLeft(false);
            player.setRight(false);
        }
        if(enemy.isWin()){
            g.setColor(new Color(100,100,100,200));
            g.fillRect(0,0,1000,500);
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
            g.drawString(enemy.getPlayerIcon()[0] + " Win Fight!",350,150);
            g.drawImage(Refresh,refreshX,refreshY,100,50,null);
            enemy.setLeft(false);
            enemy.setRight(false);
        }
    }
}