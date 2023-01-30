import java.awt.*;

public class Enemy extends GameField{
    private static double PlayerDamageEffectX;
    private static double PlayerDamageEffectY;
    private static int PlayerDamageEffectWidth;
    private static int PlayerDamageEffectHeight;

    public double getPlayerDamageEffectX() {
        return PlayerDamageEffectX;
    }

    public void setPlayerDamageEffectX(double playerDamageEffectX) {
        PlayerDamageEffectX = playerDamageEffectX;
    }

    public double getPlayerDamageEffectY() {
        return PlayerDamageEffectY;
    }

    public void setPlayerDamageEffectY(double playerDamageEffectY) {
        PlayerDamageEffectY = playerDamageEffectY;
    }

    public int getPlayerDamageEffectWidth() {
        return PlayerDamageEffectWidth;
    }

    public void setPlayerDamageEffectWidth(int playerDamageEffectWidth) {
        PlayerDamageEffectWidth = playerDamageEffectWidth;
    }

    public int getPlayerDamageEffectHeight() {
        return PlayerDamageEffectHeight;
    }

    public void setPlayerDamageEffectHeight(int playerDamageEffectHeight) {
        PlayerDamageEffectHeight = playerDamageEffectHeight;
    }

    private static Image PlayerDamageEffect;

    public Image getPlayerDamageEffect() {
        return PlayerDamageEffect;
    }

    public void setPlayerDamageEffect(Image playerDamageEffect) {
        PlayerDamageEffect = playerDamageEffect;
    }




    // True = right >>>>
    // False = left <<<<
    private static boolean focusSide = false;
    public boolean isFocusSide() {
        return focusSide;
    }

    public void setFocusSide(boolean focusside) {
        focusSide = focusside;
    }

    //Defense
    private static double DefenseTime = 90;
    public double getDefenseTime() {
        return DefenseTime;
    }

    public void setDefenseTime(double defenseTime) {
        DefenseTime = defenseTime;
    }
    private static boolean Defense;

    public boolean isDefense() {
        return Defense;
    }
    /// HEALTH
    public double getHealth() {
        return Health;
    }

    public void setHealth(double health) {
        Health = health;
    }

    private static double Health = 200;
    // ATTACK
    public Runnable setDefense(boolean defense) {
        Defense = defense;
        return null;
    }

    public boolean isAttackTimer() {
        return AttackTimer;
    }

    public void setAttackTimer(boolean attackTimer) {
        AttackTimer = attackTimer;
    }

    public boolean isAttack() {
        return Attack;
    }

    public void setAttack(boolean attack) {
        Attack = attack;
    }

    ///ATTACK
    private static boolean AttackTimer = true;
    private static boolean Attack = false;
// Movement

    private static boolean Left;
    private static boolean Right;


    public boolean isLeft() {
        return this.Left;
    }

    public void setLeft(boolean left) {
        this.Left = left;
    }

    public boolean isRight() {
        return Right;
    }

    public void setRight(boolean right) {
        Right = right;
    }

    //


    // Skin
    public static int Skin;

    public int getSkin() {
        return Skin;
    }

    public void setSkin(int skin) {
        Skin = skin;
    }

    public static void setPy(int py) {
        Py = py;
    }

    private static int Range;

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        Enemy.attackSpeed = attackSpeed;
    }

    private static double attackSpeed;

    public int getRange() {
        return Range;
    }

    public void setRange(int range) {
        Range = range;
    }


    private static double Px = 900;

    public void setPx(double px) {
        this.Px = px;
    }

    private static int Py = 270;
    private static boolean Win = false;

    public boolean isWin() {
        return Win;
    }

    public void setWin(boolean win) {
        Win = win;
    }

    private static double Speed;

    private static int Damage;
    private static Image Player;


    private static String[] PlayerIcon = {"","",""};

    public int getDamage() {
        return Damage;
    }
    public double getSpeed() {
        return Speed;
    }

    public void setSpeed(double speed) {
        Speed = speed;
    }
    public void setDamage(int damage) {
        Damage = damage;
    }
    public String[] getPlayerIcon() {
        return PlayerIcon;
    }

    public void setPlayerIcon(String[] playerIcon) {
        PlayerIcon = playerIcon;
    }
    public double getPx() {
        return Px;
    }
    public int getPy() {
        return Py;
    }

    public Image getPlayer() {
        return Player;
    }

    public void setPlayer(Image enemy) {
        Player = enemy;
    }
}
