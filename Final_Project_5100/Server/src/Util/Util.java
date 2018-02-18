/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author kkkevinxx
 */
public class Util implements Serializable{
    public static ImageIcon FillLabel(String path)
    {
        ImageIcon personPic = new ImageIcon(path);
        Image pictureL = personPic.getImage();
        Image upPicture = pictureL.getScaledInstance(129, 130, Image.SCALE_SMOOTH);
        ImageIcon pic = new ImageIcon(upPicture);
        return pic;
    }
    
    public static ImageIcon FillLabelLittle(String path)
    {
        ImageIcon personPic = new ImageIcon(path);
        Image pictureL = personPic.getImage();
        Image upPicture = pictureL.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon pic = new ImageIcon(upPicture);
        return pic;
    }
    
    public static ImageIcon FillLabelBig(String path)
    {
        ImageIcon personPic = new ImageIcon(path);
        Image pictureL = personPic.getImage();
        Image upPicture = pictureL.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon pic = new ImageIcon(upPicture);
        return pic;
    }
}
