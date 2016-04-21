package com.tentone.ganimator.studio;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import com.tentone.ganimator.Frame;
import javax.swing.JPopupMenu;
import com.tentone.ganimator.studio.Ganimator.Operation;

public class Interface extends javax.swing.JFrame
{
    private static final long serialVersionUID = 4894341988060673202L;
    public static Interface self;
    public static int time_bar_tick=0;
    final public static int time_bar_ratio=10;
    
    public Interface()
    {
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        initComponents();
    }
    
    public static void ini()
    {
        //Set Look and Feel
        try
        {
           javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception ex)
        {
            try
            {
        	javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            }
            catch(Exception ea){}
        }
        
        //Create new Interface Object
        self=new Interface();
        self.setVisible(false);

        //Disable Time Slider
        time_slider.setVerifyInputWhenFocusTarget(false);
    }
    
    //General Interface Update
    public static void updateInterface()
    {
        //Update Editor time Bar
        setTimeBarTime();
        updateTimeBar();
        
        //Update Bone and Frame List
        updateBoneList();
        updateFrameList();
        
        //Update Texture List
        updateTextureList();
    }
    
    public static void updateFrameList()
    {
        DefaultListModel model= new DefaultListModel();
        if(Ganimator.bone_selected && Ganimator.working_bone.length==1)
        {
            int i = 0;
            String[] list = Ganimator.animation.getBones()[Ganimator.working_bone[0]].getKeyFrameDescription();

            frame_selector.removeAll();
            while (i < list.length)
            {
                model.addElement(list[i]);
                i++;
            }
        }
        else
        {
            frame_selector.removeAll();
        }
        frame_selector.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    public static void updateTextureList()
    {
        int i=0;
        String[] list = Ganimator.animation.getTextureManager().getTextureList();
        
        new_texture.removeAllItems();
        edit_texture.removeAllItems();
        while(i<list.length)
        {
            new_texture.addItem(list[i]);
            edit_texture.addItem(list[i]);
            i++;
        }
    }
    
    //Updates Elements Related to Bone Settings Edition
    public static void updateBoneEditFrame()
    {
        if(Ganimator.bone_selected)
        {
            bone_loop_mode.enableInputMethods(true);
            bone_loop_mode.setSelected(Ganimator.animation.getBones()[Ganimator.working_bone[0]].loop);
            bone_edit_label.setText(Ganimator.animation.getBones()[Ganimator.working_bone[0]].label);
        }
        else
        {
            bone_loop_mode.enableInputMethods(false);
        }
    }
    
    //Updates Bone List
    public static void updateBoneList()
    {
        DefaultListModel model= new DefaultListModel();
        int i=0;
        working_bone_selector.removeAll();
        while(i<Ganimator.animation.getBones().length)
        {
            model.addElement(Ganimator.animation.getBones()[i].label);
            i++;
        }
        working_bone_selector.setModel(model);
    }
    
    //Updates Animation Texture Path
    public static void updateSettingsFrame()
    {
        texture_directorie.setText(Configuration.texture_path);
        settings_fps_lock.setSelectedIndex(Configuration.fps_lock);
        explorer_position.setSelectedIndex(Configuration.explorer_pos);
    }
    
    //Set TimeBat Time to time
    public static void setTimeBarTime()
    {
        try
        {
            time_slider.setMaximum((int)Ganimator.animation.getDuration()*10);
        }
        catch(Exception e)
        {
            time_slider.setMaximum(0);
        }
    }
    
    //Returns Time Bar Actual Time
    public static float getTimeBarTime()
    {
        return time_slider.getValue()/10f;
    }
    
    //Update Time bar Value based on actual woking_bone
    public static void updateTimeBar()
    {
        time_slider.setValue((int)(Ganimator.animation.getTime()*10f));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bone_edit_frame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        bone_loop_mode = new javax.swing.JCheckBox();
        bone_edit_frame_ok = new javax.swing.JButton();
        bone_edit_label = new javax.swing.JTextField();
        bone_add_frame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        new_label = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        new_texture = new javax.swing.JComboBox();
        new_size_x = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        new_ori_x = new javax.swing.JTextField();
        new_ori_y = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        new_size_y = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        new_alpha = new javax.swing.JTextField();
        new_rotation = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        new_add = new javax.swing.JButton();
        new_loop = new javax.swing.JCheckBox();
        settings_frame = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        texture_directorie_change = new javax.swing.JButton();
        settings_frame_ok = new javax.swing.JButton();
        texture_directorie = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        settings_fps_lock = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        explorer_position = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        about_frame = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        about_title = new javax.swing.JLabel();
        about_ganimator_logo = new javax.swing.JLabel();
        about_ganimator_version = new javax.swing.JLabel();
        about_email = new javax.swing.JLabel();
        about_libgdx_logo = new javax.swing.JLabel();
        frame_add_frame = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        add_frame_time = new javax.swing.JTextField();
        add_frame_add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        frame_edit_frame = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        edit_size_x = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        edit_ori_x = new javax.swing.JTextField();
        edit_ori_y = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        edit_size_y = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        edit_alpha = new javax.swing.JTextField();
        edit_rotation = new javax.swing.JTextField();
        edit_cancel = new javax.swing.JButton();
        edit_okay = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        edit_pos_x = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        edit_pos_y = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edit_texture = new javax.swing.JComboBox();
        export_image_sequence_frame = new javax.swing.JFrame();
        export_image_sequence_panel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        export_fps = new javax.swing.JTextField();
        export_format = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        error_frame = new javax.swing.JFrame();
        error_panel = new javax.swing.JPanel();
        error_message = new javax.swing.JLabel();
        error_okay = new javax.swing.JButton();
        dialog_frame = new javax.swing.JFrame();
        dialog_panel = new javax.swing.JPanel();
        dialog_message = new javax.swing.JLabel();
        dialog_yes = new javax.swing.JButton();
        dialog_no = new javax.swing.JButton();
        split_pane = new javax.swing.JSplitPane();
        panel_explorer = new javax.swing.JPanel();
        bone_delete = new javax.swing.JButton();
        working_bone_selector_box = new javax.swing.JScrollPane();
        working_bone_selector = new javax.swing.JList();
        working_bone_selector_text = new javax.swing.JLabel();
        bone_edit = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        frame_delete = new javax.swing.JButton();
        frame_selector_box = new javax.swing.JScrollPane();
        frame_selector = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        animation_speed = new javax.swing.JSlider();
        animation_speed_indicator = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bone_up = new javax.swing.JButton();
        bone_down = new javax.swing.JButton();
        bone_edit1 = new javax.swing.JButton();
        panel_frame = new javax.swing.JPanel();
        container = new java.awt.Panel();
        time_slider = new javax.swing.JSlider();
        play_button = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        menu_file_new = new javax.swing.JMenuItem();
        menu_file_save = new javax.swing.JMenuItem();
        menu_file_load = new javax.swing.JMenuItem();
        menu_file_export = new javax.swing.JMenu();
        menu_export_image_sequence = new javax.swing.JMenuItem();
        menu_settings = new javax.swing.JMenuItem();
        menu_file_exit = new javax.swing.JMenuItem();
        menu_about = new javax.swing.JMenu();
        menu_editor_about = new javax.swing.JMenuItem();

        bone_edit_frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        bone_edit_frame.setTitle("Edit Bone");
        bone_edit_frame.setAlwaysOnTop(true);
        bone_edit_frame.setBackground(new java.awt.Color(70, 70, 70));
        bone_edit_frame.setMinimumSize(new java.awt.Dimension(350, 90));
        bone_edit_frame.setResizable(false);
        bone_edit_frame.setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(70, 70, 70));

        jLabel12.setBackground(new java.awt.Color(70, 70, 70));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Label:");

        bone_loop_mode.setBackground(new java.awt.Color(70, 70, 70));
        bone_loop_mode.setForeground(new java.awt.Color(255, 255, 255));
        bone_loop_mode.setText("Loop Mode");
        bone_loop_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bone_loop_modeActionPerformed(evt);
            }
        });

        bone_edit_frame_ok.setBackground(new java.awt.Color(70, 70, 70));
        bone_edit_frame_ok.setForeground(new java.awt.Color(255, 255, 255));
        bone_edit_frame_ok.setText("Ok");
        bone_edit_frame_ok.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bone_edit_frame_ok.setContentAreaFilled(false);
        bone_edit_frame_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bone_edit_frame_okActionPerformed(evt);
            }
        });

        bone_edit_label.setBackground(new java.awt.Color(90, 90, 90));
        bone_edit_label.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bone_edit_label))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bone_loop_mode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(bone_edit_frame_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(bone_edit_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bone_edit_frame_ok)
                    .addComponent(bone_loop_mode, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bone_edit_frameLayout = new javax.swing.GroupLayout(bone_edit_frame.getContentPane());
        bone_edit_frame.getContentPane().setLayout(bone_edit_frameLayout);
        bone_edit_frameLayout.setHorizontalGroup(
            bone_edit_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bone_edit_frameLayout.setVerticalGroup(
            bone_edit_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bone_add_frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        bone_add_frame.setTitle("Add Bone");
        bone_add_frame.setAlwaysOnTop(true);
        bone_add_frame.setMinimumSize(new java.awt.Dimension(300, 170));
        bone_add_frame.setResizable(false);
        bone_add_frame.setType(java.awt.Window.Type.UTILITY);

        jPanel2.setBackground(new java.awt.Color(70, 70, 70));

        jLabel17.setBackground(new java.awt.Color(70, 70, 70));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Label");

        new_label.setBackground(new java.awt.Color(90, 90, 90));
        new_label.setForeground(new java.awt.Color(255, 255, 255));
        new_label.setText("bone");
        new_label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_labelActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(70, 70, 70));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Texture");

        new_size_x.setBackground(new java.awt.Color(90, 90, 90));
        new_size_x.setForeground(new java.awt.Color(255, 255, 255));
        new_size_x.setText("0");
        new_size_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_size_xActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(70, 70, 70));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Size");

        jLabel18.setBackground(new java.awt.Color(70, 70, 70));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Ori");

        new_ori_x.setBackground(new java.awt.Color(90, 90, 90));
        new_ori_x.setForeground(new java.awt.Color(255, 255, 255));
        new_ori_x.setText("0");

        new_ori_y.setBackground(new java.awt.Color(90, 90, 90));
        new_ori_y.setForeground(new java.awt.Color(255, 255, 255));
        new_ori_y.setText("0");

        jLabel19.setBackground(new java.awt.Color(70, 70, 70));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("X");

        jLabel3.setBackground(new java.awt.Color(70, 70, 70));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");

        new_size_y.setBackground(new java.awt.Color(90, 90, 90));
        new_size_y.setForeground(new java.awt.Color(255, 255, 255));
        new_size_y.setText("0");

        jLabel20.setBackground(new java.awt.Color(70, 70, 70));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Rotation");

        jLabel21.setBackground(new java.awt.Color(70, 70, 70));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Alpha");

        new_alpha.setBackground(new java.awt.Color(90, 90, 90));
        new_alpha.setForeground(new java.awt.Color(255, 255, 255));
        new_alpha.setText("1");

        new_rotation.setBackground(new java.awt.Color(90, 90, 90));
        new_rotation.setForeground(new java.awt.Color(255, 255, 255));
        new_rotation.setText("0");

        jButton3.setBackground(new java.awt.Color(70, 70, 70));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancel");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        new_add.setBackground(new java.awt.Color(70, 70, 70));
        new_add.setForeground(new java.awt.Color(255, 255, 255));
        new_add.setText("New Bone");
        new_add.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        new_add.setContentAreaFilled(false);
        new_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_addActionPerformed(evt);
            }
        });

        new_loop.setBackground(new java.awt.Color(70, 70, 70));
        new_loop.setForeground(new java.awt.Color(255, 255, 255));
        new_loop.setSelected(true);
        new_loop.setText("Loop Mode");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(new_label))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(new_texture, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(new_ori_x, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(new_ori_y, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(new_alpha, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(new_loop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(new_add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(new_size_x, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(new_size_y, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(new_rotation)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(new_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(new_texture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(new_size_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(new_size_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(new_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(new_ori_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(new_ori_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(new_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_add)
                    .addComponent(new_loop, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout bone_add_frameLayout = new javax.swing.GroupLayout(bone_add_frame.getContentPane());
        bone_add_frame.getContentPane().setLayout(bone_add_frameLayout);
        bone_add_frameLayout.setHorizontalGroup(
            bone_add_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bone_add_frameLayout.setVerticalGroup(
            bone_add_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        settings_frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        settings_frame.setTitle("Settings");
        settings_frame.setAlwaysOnTop(true);
        settings_frame.setMinimumSize(new java.awt.Dimension(410, 150));
        settings_frame.setName("Settings"); // NOI18N
        settings_frame.setType(java.awt.Window.Type.UTILITY);

        jPanel3.setBackground(new java.awt.Color(70, 70, 70));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        texture_directorie_change.setBackground(new java.awt.Color(70, 70, 70));
        texture_directorie_change.setForeground(new java.awt.Color(255, 255, 255));
        texture_directorie_change.setText("Change");
        texture_directorie_change.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        texture_directorie_change.setContentAreaFilled(false);
        texture_directorie_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texture_directorie_changeActionPerformed(evt);
            }
        });

        settings_frame_ok.setBackground(new java.awt.Color(70, 70, 70));
        settings_frame_ok.setForeground(new java.awt.Color(255, 255, 255));
        settings_frame_ok.setText("Ok");
        settings_frame_ok.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        settings_frame_ok.setContentAreaFilled(false);
        settings_frame_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settings_frame_okActionPerformed(evt);
            }
        });

        texture_directorie.setBackground(new java.awt.Color(90, 90, 90));
        texture_directorie.setForeground(new java.awt.Color(255, 255, 255));
        texture_directorie.setText(" ");
        texture_directorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texture_directorieActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(70, 70, 70));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Textures Directorie:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Editor FPS Lock Fix (AMD):");

        settings_fps_lock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Off", "60", "120" }));
        settings_fps_lock.setToolTipText("");
        settings_fps_lock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settings_fps_lockActionPerformed(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Explorer Position:");

        explorer_position.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Right", "Left" }));
        explorer_position.setToolTipText("");
        explorer_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explorer_positionActionPerformed(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(200, 200, 200));
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("(Need to Restart)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texture_directorie, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(settings_frame_ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(texture_directorie_change, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(settings_fps_lock, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(explorer_position, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texture_directorie_change)
                    .addComponent(jLabel16)
                    .addComponent(texture_directorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(settings_fps_lock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(explorer_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(settings_frame_ok)
                .addContainerGap())
        );

        javax.swing.GroupLayout settings_frameLayout = new javax.swing.GroupLayout(settings_frame.getContentPane());
        settings_frame.getContentPane().setLayout(settings_frameLayout);
        settings_frameLayout.setHorizontalGroup(
            settings_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        settings_frameLayout.setVerticalGroup(
            settings_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_frameLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        about_frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        about_frame.setTitle("About");
        about_frame.setAlwaysOnTop(true);
        about_frame.setMinimumSize(new java.awt.Dimension(280, 210));
        about_frame.setPreferredSize(new java.awt.Dimension(280, 230));
        about_frame.setResizable(false);
        about_frame.setType(java.awt.Window.Type.UTILITY);
        about_frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                about_frameComponentShown(evt);
            }
        });
        about_frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                about_frameWindowClosing(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(70, 70, 70));

        about_title.setForeground(new java.awt.Color(255, 255, 255));
        about_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about_title.setText("About");

        about_ganimator_logo.setForeground(new java.awt.Color(255, 255, 255));
        about_ganimator_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ganimator_logo.png"))); // NOI18N

        about_ganimator_version.setForeground(new java.awt.Color(255, 255, 255));
        about_ganimator_version.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about_ganimator_version.setText("Ganimator "+Ganimator.version);

        about_email.setForeground(new java.awt.Color(255, 255, 255));
        about_email.setText("tentone@outlook.com");

        about_libgdx_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libgdx_logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addComponent(about_libgdx_logo)
                    .addGap(60, 60, 60))
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(about_ganimator_version, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(about_email))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(about_ganimator_logo))))
                    .addGap(10, 10, 10)))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(about_title)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(about_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(about_ganimator_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(about_ganimator_version)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(about_email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(about_libgdx_logo)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout about_frameLayout = new javax.swing.GroupLayout(about_frame.getContentPane());
        about_frame.getContentPane().setLayout(about_frameLayout);
        about_frameLayout.setHorizontalGroup(
            about_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        about_frameLayout.setVerticalGroup(
            about_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        about_frame.getAccessibleContext().setAccessibleDescription("");

        frame_add_frame.setTitle("Add Frame");
        frame_add_frame.setAlwaysOnTop(true);
        frame_add_frame.setMinimumSize(new java.awt.Dimension(200, 65));
        frame_add_frame.setResizable(false);
        frame_add_frame.setType(java.awt.Window.Type.UTILITY);

        jPanel4.setBackground(new java.awt.Color(70, 70, 70));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel23.setBackground(new java.awt.Color(70, 70, 70));
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Time:");

        add_frame_time.setBackground(new java.awt.Color(90, 90, 90));
        add_frame_time.setForeground(new java.awt.Color(255, 255, 255));
        add_frame_time.setText(" ");
        add_frame_time.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add_frame_timeKeyPressed(evt);
            }
        });

        add_frame_add.setBackground(new java.awt.Color(70, 70, 70));
        add_frame_add.setForeground(new java.awt.Color(255, 255, 255));
        add_frame_add.setText("Add");
        add_frame_add.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add_frame_add.setContentAreaFilled(false);
        add_frame_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_frame_addActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(70, 70, 70));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("s");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add_frame_time, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add_frame_add, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(add_frame_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_frame_add)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout frame_add_frameLayout = new javax.swing.GroupLayout(frame_add_frame.getContentPane());
        frame_add_frame.getContentPane().setLayout(frame_add_frameLayout);
        frame_add_frameLayout.setHorizontalGroup(
            frame_add_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frame_add_frameLayout.setVerticalGroup(
            frame_add_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frame_edit_frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frame_edit_frame.setTitle("Edit Frame");
        frame_edit_frame.setAlwaysOnTop(true);
        frame_edit_frame.setMinimumSize(new java.awt.Dimension(340, 200));
        frame_edit_frame.setType(java.awt.Window.Type.UTILITY);

        jPanel5.setBackground(new java.awt.Color(70, 70, 70));
        jPanel5.setMinimumSize(new java.awt.Dimension(280, 105));

        edit_size_x.setBackground(new java.awt.Color(90, 90, 90));
        edit_size_x.setForeground(new java.awt.Color(255, 255, 255));
        edit_size_x.setText("0");
        edit_size_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_size_xActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(70, 70, 70));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Size");

        jLabel25.setBackground(new java.awt.Color(70, 70, 70));
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Ori");

        edit_ori_x.setBackground(new java.awt.Color(90, 90, 90));
        edit_ori_x.setForeground(new java.awt.Color(255, 255, 255));
        edit_ori_x.setText("0");

        edit_ori_y.setBackground(new java.awt.Color(90, 90, 90));
        edit_ori_y.setForeground(new java.awt.Color(255, 255, 255));
        edit_ori_y.setText("0");

        jLabel26.setBackground(new java.awt.Color(70, 70, 70));
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("X");

        jLabel7.setBackground(new java.awt.Color(70, 70, 70));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");

        edit_size_y.setBackground(new java.awt.Color(90, 90, 90));
        edit_size_y.setForeground(new java.awt.Color(255, 255, 255));
        edit_size_y.setText("0");

        jLabel27.setBackground(new java.awt.Color(70, 70, 70));
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Rotation");

        jLabel28.setBackground(new java.awt.Color(70, 70, 70));
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Alpha");

        edit_alpha.setBackground(new java.awt.Color(90, 90, 90));
        edit_alpha.setForeground(new java.awt.Color(255, 255, 255));
        edit_alpha.setText("1");

        edit_rotation.setBackground(new java.awt.Color(90, 90, 90));
        edit_rotation.setForeground(new java.awt.Color(255, 255, 255));
        edit_rotation.setText("0");

        edit_cancel.setBackground(new java.awt.Color(70, 70, 70));
        edit_cancel.setForeground(new java.awt.Color(255, 255, 255));
        edit_cancel.setText("Cancel");
        edit_cancel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_cancel.setContentAreaFilled(false);
        edit_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_cancelActionPerformed(evt);
            }
        });

        edit_okay.setBackground(new java.awt.Color(70, 70, 70));
        edit_okay.setForeground(new java.awt.Color(255, 255, 255));
        edit_okay.setText("Ok");
        edit_okay.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_okay.setContentAreaFilled(false);
        edit_okay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_okayActionPerformed(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(70, 70, 70));
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Position");

        edit_pos_x.setBackground(new java.awt.Color(90, 90, 90));
        edit_pos_x.setForeground(new java.awt.Color(255, 255, 255));
        edit_pos_x.setText("0");

        jLabel30.setBackground(new java.awt.Color(70, 70, 70));
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("X");

        edit_pos_y.setBackground(new java.awt.Color(90, 90, 90));
        edit_pos_y.setForeground(new java.awt.Color(255, 255, 255));
        edit_pos_y.setText("0");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Texture:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(edit_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_okay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_ori_x, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_ori_y, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addGap(116, 116, 116))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_size_x)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_size_y)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_rotation))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_pos_x)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_pos_y)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addGap(5, 5, 5)
                        .addComponent(edit_alpha))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_texture, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit_texture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(edit_pos_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(edit_pos_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(edit_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(edit_size_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(edit_size_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(edit_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(edit_ori_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(edit_ori_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit_okay)
                    .addComponent(edit_cancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout frame_edit_frameLayout = new javax.swing.GroupLayout(frame_edit_frame.getContentPane());
        frame_edit_frame.getContentPane().setLayout(frame_edit_frameLayout);
        frame_edit_frameLayout.setHorizontalGroup(
            frame_edit_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frame_edit_frameLayout.setVerticalGroup(
            frame_edit_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        export_image_sequence_frame.setTitle("Export Animation");
        export_image_sequence_frame.setAlwaysOnTop(true);
        export_image_sequence_frame.setMinimumSize(new java.awt.Dimension(300, 200));
        export_image_sequence_frame.setType(java.awt.Window.Type.UTILITY);

        export_image_sequence_panel.setBackground(new java.awt.Color(70, 70, 70));
        export_image_sequence_panel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(70, 70, 70));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Export Animation Image Sequence");

        jLabel10.setBackground(new java.awt.Color(70, 70, 70));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FPS:");

        jLabel11.setBackground(new java.awt.Color(70, 70, 70));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Format:");

        jButton5.setBackground(new java.awt.Color(70, 70, 70));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Export");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.setContentAreaFilled(false);

        export_fps.setBackground(new java.awt.Color(90, 90, 90));
        export_fps.setForeground(new java.awt.Color(255, 255, 255));
        export_fps.setText("60");

        export_format.setBackground(new java.awt.Color(70, 70, 70));
        export_format.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PNG", "BMP", "JPEG" }));
        export_format.setToolTipText("");

        jLabel13.setBackground(new java.awt.Color(70, 70, 70));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Folder:");

        jTextField1.setBackground(new java.awt.Color(90, 90, 90));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        jButton6.setBackground(new java.awt.Color(70, 70, 70));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Select");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.setContentAreaFilled(false);

        javax.swing.GroupLayout export_image_sequence_panelLayout = new javax.swing.GroupLayout(export_image_sequence_panel);
        export_image_sequence_panel.setLayout(export_image_sequence_panelLayout);
        export_image_sequence_panelLayout.setHorizontalGroup(
            export_image_sequence_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, export_image_sequence_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(export_image_sequence_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, export_image_sequence_panelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(export_fps, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, export_image_sequence_panelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(export_format, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(export_image_sequence_panelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(export_image_sequence_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))))
                .addContainerGap())
        );
        export_image_sequence_panelLayout.setVerticalGroup(
            export_image_sequence_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(export_image_sequence_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(export_image_sequence_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(export_fps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(export_image_sequence_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(export_format, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(export_image_sequence_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        javax.swing.GroupLayout export_image_sequence_frameLayout = new javax.swing.GroupLayout(export_image_sequence_frame.getContentPane());
        export_image_sequence_frame.getContentPane().setLayout(export_image_sequence_frameLayout);
        export_image_sequence_frameLayout.setHorizontalGroup(
            export_image_sequence_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(export_image_sequence_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        export_image_sequence_frameLayout.setVerticalGroup(
            export_image_sequence_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(export_image_sequence_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        error_frame.setTitle("Error");
        error_frame.setAlwaysOnTop(true);
        error_frame.setName("Error"); // NOI18N
        error_frame.setResizable(false);
        error_frame.setType(java.awt.Window.Type.POPUP);

        error_panel.setBackground(new java.awt.Color(70, 70, 70));
        error_panel.setForeground(new java.awt.Color(255, 255, 255));

        error_message.setForeground(new java.awt.Color(255, 255, 255));
        error_message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        error_message.setText("Error Message");
        error_message.setAlignmentX(0.5F);

        error_okay.setBackground(new java.awt.Color(70, 70, 70));
        error_okay.setForeground(new java.awt.Color(255, 255, 255));
        error_okay.setText("Ok");
        error_okay.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        error_okay.setContentAreaFilled(false);

        javax.swing.GroupLayout error_panelLayout = new javax.swing.GroupLayout(error_panel);
        error_panel.setLayout(error_panelLayout);
        error_panelLayout.setHorizontalGroup(
            error_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(error_panelLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(error_okay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
            .addComponent(error_message, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        error_panelLayout.setVerticalGroup(
            error_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(error_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(error_message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error_okay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout error_frameLayout = new javax.swing.GroupLayout(error_frame.getContentPane());
        error_frame.getContentPane().setLayout(error_frameLayout);
        error_frameLayout.setHorizontalGroup(
            error_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(error_frameLayout.createSequentialGroup()
                .addComponent(error_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        error_frameLayout.setVerticalGroup(
            error_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(error_frameLayout.createSequentialGroup()
                .addComponent(error_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        dialog_frame.setAlwaysOnTop(true);
        dialog_frame.setName("Error"); // NOI18N
        dialog_frame.setResizable(false);
        dialog_frame.setType(java.awt.Window.Type.POPUP);

        dialog_panel.setBackground(new java.awt.Color(70, 70, 70));
        dialog_panel.setForeground(new java.awt.Color(255, 255, 255));

        dialog_message.setForeground(new java.awt.Color(255, 255, 255));
        dialog_message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dialog_message.setText("Dialog Message");
        dialog_message.setAlignmentX(0.5F);

        dialog_yes.setBackground(new java.awt.Color(70, 70, 70));
        dialog_yes.setForeground(new java.awt.Color(255, 255, 255));
        dialog_yes.setText("Yes");
        dialog_yes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dialog_yes.setContentAreaFilled(false);

        dialog_no.setBackground(new java.awt.Color(70, 70, 70));
        dialog_no.setForeground(new java.awt.Color(255, 255, 255));
        dialog_no.setText("No");
        dialog_no.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dialog_no.setContentAreaFilled(false);
        dialog_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialog_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialog_panelLayout = new javax.swing.GroupLayout(dialog_panel);
        dialog_panel.setLayout(dialog_panelLayout);
        dialog_panelLayout.setHorizontalGroup(
            dialog_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dialog_message, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dialog_yes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(dialog_no, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialog_panelLayout.setVerticalGroup(
            dialog_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialog_message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dialog_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dialog_yes)
                    .addComponent(dialog_no))
                .addContainerGap())
        );

        javax.swing.GroupLayout dialog_frameLayout = new javax.swing.GroupLayout(dialog_frame.getContentPane());
        dialog_frame.getContentPane().setLayout(dialog_frameLayout);
        dialog_frameLayout.setHorizontalGroup(
            dialog_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_frameLayout.createSequentialGroup()
                .addComponent(dialog_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        dialog_frameLayout.setVerticalGroup(
            dialog_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_frameLayout.createSequentialGroup()
                .addComponent(dialog_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ganimator Studio "+Ganimator.version);
        setBackground(new java.awt.Color(70, 70, 70));
        setFocusTraversalPolicyProvider(true);
        setIconImage(new ImageIcon("icon.png").getImage());
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(985, 682));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        split_pane.setBackground(new java.awt.Color(0, 0, 0));
        split_pane.setBorder(null);
        split_pane.setDividerSize(1);
        split_pane.setResizeWeight(1.0);
        split_pane.setContinuousLayout(true);
        split_pane.setDoubleBuffered(true);

        panel_explorer.setBackground(new java.awt.Color(70, 70, 70));
        panel_explorer.setForeground(new java.awt.Color(255, 255, 255));
        panel_explorer.setToolTipText("");
        panel_explorer.setAutoscrolls(true);

        bone_delete.setBackground(new java.awt.Color(70, 70, 70));
        bone_delete.setForeground(new java.awt.Color(255, 255, 255));
        bone_delete.setText("Delete");
        bone_delete.setToolTipText("");
        bone_delete.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bone_delete.setContentAreaFilled(false);
        bone_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bone_deleteActionPerformed(evt);
            }
        });

        working_bone_selector.setBackground(new java.awt.Color(100, 100, 100));
        working_bone_selector.setForeground(new java.awt.Color(200, 200, 200));
        working_bone_selector.setToolTipText("");
        working_bone_selector.setAutoscrolls(false);
        working_bone_selector.setVerifyInputWhenFocusTarget(false);
        working_bone_selector.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                working_bone_selectorValueChanged(evt);
            }
        });
        working_bone_selector_box.setViewportView(working_bone_selector);

        working_bone_selector_text.setBackground(new java.awt.Color(40, 40, 40));
        working_bone_selector_text.setForeground(new java.awt.Color(255, 255, 255));
        working_bone_selector_text.setText("Bone");
        working_bone_selector_text.setToolTipText("");

        bone_edit.setBackground(new java.awt.Color(70, 70, 70));
        bone_edit.setForeground(new java.awt.Color(255, 255, 255));
        bone_edit.setText("Edit");
        bone_edit.setToolTipText("");
        bone_edit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bone_edit.setContentAreaFilled(false);
        bone_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bone_editActionPerformed(evt);
            }
        });

        separador.setBackground(new java.awt.Color(70, 70, 70));
        separador.setForeground(new java.awt.Color(50, 50, 50));
        separador.setToolTipText("");
        separador.setMinimumSize(new java.awt.Dimension(0, 1));

        jLabel14.setBackground(new java.awt.Color(40, 40, 40));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Frames");
        jLabel14.setToolTipText("");

        frame_delete.setBackground(new java.awt.Color(70, 70, 70));
        frame_delete.setForeground(new java.awt.Color(255, 255, 255));
        frame_delete.setText("Delete");
        frame_delete.setToolTipText("");
        frame_delete.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frame_delete.setContentAreaFilled(false);
        frame_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame_deleteActionPerformed(evt);
            }
        });

        frame_selector.setBackground(new java.awt.Color(100, 100, 100));
        frame_selector.setForeground(new java.awt.Color(200, 200, 200));
        frame_selector.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        frame_selector.setAutoscrolls(false);
        frame_selector.setVerifyInputWhenFocusTarget(false);
        frame_selector.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                frame_selectorValueChanged(evt);
            }
        });
        frame_selector_box.setViewportView(frame_selector);

        jButton2.setBackground(new java.awt.Color(70, 70, 70));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add");
        jButton2.setToolTipText("");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(70, 70, 70));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add");
        jButton4.setToolTipText("");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(70, 70, 70));
        jSeparator1.setForeground(new java.awt.Color(50, 50, 50));
        jSeparator1.setToolTipText("");

        jLabel15.setBackground(new java.awt.Color(40, 40, 40));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Animation Play Settings");
        jLabel15.setToolTipText("");

        jLabel22.setBackground(new java.awt.Color(40, 40, 40));
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Speed");
        jLabel22.setToolTipText("");

        animation_speed.setBackground(new java.awt.Color(70, 70, 70));
        animation_speed.setForeground(new java.awt.Color(255, 255, 255));
        animation_speed.setMaximum(300);
        animation_speed.setMinimum(10);
        animation_speed.setSnapToTicks(true);
        animation_speed.setToolTipText("");
        animation_speed.setValue(100);
        animation_speed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                animation_speedStateChanged(evt);
            }
        });
        animation_speed.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                animation_speedPropertyChange(evt);
            }
        });

        animation_speed_indicator.setForeground(new java.awt.Color(255, 255, 255));
        animation_speed_indicator.setText("1.0x");

        jButton1.setBackground(new java.awt.Color(70, 70, 70));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Edit");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bone_up.setBackground(new java.awt.Color(70, 70, 70));
        bone_up.setForeground(new java.awt.Color(255, 255, 255));
        bone_up.setText("^");
        bone_up.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bone_up.setContentAreaFilled(false);
        bone_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bone_upActionPerformed(evt);
            }
        });

        bone_down.setBackground(new java.awt.Color(70, 70, 70));
        bone_down.setForeground(new java.awt.Color(255, 255, 255));
        bone_down.setText("v");
        bone_down.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bone_down.setContentAreaFilled(false);
        bone_down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bone_downActionPerformed(evt);
            }
        });

        bone_edit1.setBackground(new java.awt.Color(70, 70, 70));
        bone_edit1.setForeground(new java.awt.Color(255, 255, 255));
        bone_edit1.setText("Clone");
        bone_edit1.setToolTipText("");
        bone_edit1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bone_edit1.setContentAreaFilled(false);
        bone_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bone_edit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_explorerLayout = new javax.swing.GroupLayout(panel_explorer);
        panel_explorer.setLayout(panel_explorerLayout);
        panel_explorerLayout.setHorizontalGroup(
            panel_explorerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panel_explorerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_explorerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_explorerLayout.createSequentialGroup()
                        .addComponent(working_bone_selector_box, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_explorerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bone_up)
                            .addComponent(bone_down, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_explorerLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(animation_speed, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(animation_speed_indicator, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(frame_selector_box)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_explorerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frame_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_explorerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bone_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bone_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bone_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_explorerLayout.createSequentialGroup()
                        .addGroup(panel_explorerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(working_bone_selector_text)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_explorerLayout.setVerticalGroup(
            panel_explorerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_explorerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(working_bone_selector_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_explorerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_explorerLayout.createSequentialGroup()
                        .addComponent(bone_up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bone_down, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(working_bone_selector_box, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_explorerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bone_delete)
                    .addComponent(bone_edit)
                    .addComponent(jButton2)
                    .addComponent(bone_edit1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_selector_box, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_explorerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frame_delete)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_explorerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22)
                    .addComponent(animation_speed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(animation_speed_indicator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        if(Configuration.explorer_pos==0)
        {
            split_pane.setRightComponent(panel_explorer);
        }
        else
        {
            split_pane.setLeftComponent(panel_explorer);
        }

        panel_frame.setBackground(new java.awt.Color(70, 70, 70));
        panel_frame.setForeground(new java.awt.Color(255, 255, 255));
        panel_frame.setToolTipText("");

        container.setBackground(new java.awt.Color(100, 100, 100));
        container.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                containerComponentResized(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        time_slider.setBackground(new java.awt.Color(70, 70, 70));
        time_slider.setForeground(new java.awt.Color(255, 255, 255));
        time_slider.setMajorTickSpacing(10);
        time_slider.setMaximum(0);
        time_slider.setMinorTickSpacing(1);
        time_slider.setPaintTicks(true);
        time_slider.setSnapToTicks(true);
        time_slider.setToolTipText("");
        time_slider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        time_slider.setVerifyInputWhenFocusTarget(false);
        time_slider.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                time_sliderPropertyChange(evt);
            }
        });

        play_button.setBackground(new java.awt.Color(70, 70, 70));
        play_button.setForeground(new java.awt.Color(255, 255, 255));
        play_button.setText("Play");
        play_button.setToolTipText("");
        play_button.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        play_button.setContentAreaFilled(false);
        play_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_frameLayout = new javax.swing.GroupLayout(panel_frame);
        panel_frame.setLayout(panel_frameLayout);
        panel_frameLayout.setHorizontalGroup(
            panel_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_frameLayout.createSequentialGroup()
                .addComponent(time_slider, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(play_button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_frameLayout.setVerticalGroup(
            panel_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_frameLayout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_frameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(play_button)
                        .addGap(8, 8, 8))))
        );

        if(Configuration.explorer_pos==0)
        {
            split_pane.setLeftComponent(panel_frame);
        }
        else
        {
            split_pane.setRightComponent(panel_frame);
        }

        menu.setBackground(new java.awt.Color(70, 70, 70));
        menu.setBorder(null);
        menu.setForeground(new java.awt.Color(70, 70, 70));
        menu.setToolTipText("");
        menu.setBorderPainted(false);
        menu.setFocusCycleRoot(true);
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuMouseEntered(evt);
            }
        });

        menu_file.setBackground(new java.awt.Color(70, 70, 70));
        menu_file.setText("File");
        menu_file.setToolTipText("");
        menu_file.setFocusCycleRoot(true);

        menu_file_new.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menu_file_new.setBackground(new java.awt.Color(70, 70, 70));
        menu_file_new.setForeground(new java.awt.Color(255, 255, 255));
        menu_file_new.setText("New Animation");
        menu_file_new.setToolTipText("");
        menu_file_new.setBorder(null);
        menu_file_new.setFocusCycleRoot(true);
        menu_file_new.setFocusable(true);
        menu_file_new.setOpaque(true);
        menu_file_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_file_newActionPerformed(evt);
            }
        });
        menu_file.add(menu_file_new);

        menu_file_save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menu_file_save.setBackground(new java.awt.Color(70, 70, 70));
        menu_file_save.setForeground(new java.awt.Color(255, 255, 255));
        menu_file_save.setText("Save File");
        menu_file_save.setToolTipText("");
        menu_file_save.setBorder(null);
        menu_file_save.setFocusCycleRoot(true);
        menu_file_save.setFocusable(true);
        menu_file_save.setOpaque(true);
        menu_file_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_file_saveActionPerformed(evt);
            }
        });
        menu_file.add(menu_file_save);

        menu_file_load.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menu_file_load.setBackground(new java.awt.Color(70, 70, 70));
        menu_file_load.setForeground(new java.awt.Color(255, 255, 255));
        menu_file_load.setText("Load File");
        menu_file_load.setToolTipText("");
        menu_file_load.setBorder(null);
        menu_file_load.setFocusCycleRoot(true);
        menu_file_load.setFocusable(true);
        menu_file_load.setOpaque(true);
        menu_file_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_file_loadActionPerformed(evt);
            }
        });
        menu_file.add(menu_file_load);

        menu_file_export.setBackground(new java.awt.Color(70, 70, 70));
        menu_file_export.setForeground(new java.awt.Color(255, 255, 255));
        menu_file_export.setText("Export");
        menu_file_export.setToolTipText("");
        menu_file_export.setFocusCycleRoot(true);
        menu_file_export.setOpaque(true);

        menu_export_image_sequence.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menu_export_image_sequence.setBackground(new java.awt.Color(70, 70, 70));
        menu_export_image_sequence.setForeground(new java.awt.Color(255, 255, 255));
        menu_export_image_sequence.setText("Image Sequence");
        menu_export_image_sequence.setToolTipText("");
        menu_export_image_sequence.setBorder(null);
        menu_export_image_sequence.setFocusCycleRoot(true);
        menu_export_image_sequence.setFocusable(true);
        menu_export_image_sequence.setOpaque(true);
        menu_export_image_sequence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_export_image_sequenceActionPerformed(evt);
            }
        });
        menu_file_export.add(menu_export_image_sequence);

        menu_file.add(menu_file_export);

        menu_settings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menu_settings.setBackground(new java.awt.Color(70, 70, 70));
        menu_settings.setForeground(new java.awt.Color(255, 255, 255));
        menu_settings.setText("Settings");
        menu_settings.setToolTipText("");
        menu_settings.setBorder(null);
        menu_settings.setFocusCycleRoot(true);
        menu_settings.setFocusable(true);
        menu_settings.setOpaque(true);
        menu_settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_settingsActionPerformed(evt);
            }
        });
        menu_file.add(menu_settings);

        menu_file_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menu_file_exit.setBackground(new java.awt.Color(70, 70, 70));
        menu_file_exit.setForeground(new java.awt.Color(255, 255, 255));
        menu_file_exit.setText("Exit");
        menu_file_exit.setToolTipText("");
        menu_file_exit.setBorder(null);
        menu_file_exit.setFocusCycleRoot(true);
        menu_file_exit.setFocusable(true);
        menu_file_exit.setOpaque(true);
        menu_file_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_file_exitActionPerformed(evt);
            }
        });
        menu_file.add(menu_file_exit);

        menu.add(menu_file);

        menu_about.setBackground(new java.awt.Color(70, 70, 70));
        menu_about.setText("About");
        menu_about.setToolTipText("");
        menu_about.setFocusCycleRoot(true);

        menu_editor_about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menu_editor_about.setBackground(new java.awt.Color(70, 70, 70));
        menu_editor_about.setForeground(new java.awt.Color(255, 255, 255));
        menu_editor_about.setText("About");
        menu_editor_about.setToolTipText("");
        menu_editor_about.setBorder(null);
        menu_editor_about.setContentAreaFilled(false);
        menu_editor_about.setFocusCycleRoot(true);
        menu_editor_about.setFocusable(true);
        menu_editor_about.setOpaque(true);
        menu_editor_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_editor_aboutActionPerformed(evt);
            }
        });
        menu_about.add(menu_editor_about);

        menu.add(menu_about);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split_pane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(split_pane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

    private void menu_file_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_file_newActionPerformed
        //Menu New Animation
        int n = JOptionPane.showConfirmDialog(null,"Any unsaved work will be lost?\n Create new Animation?" , "New", JOptionPane.YES_NO_OPTION);
        if(n==0)
        {
            Ganimator.newAnimation();
        }
        updateInterface();
    }//GEN-LAST:event_menu_file_newActionPerformed

    private void menu_file_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_file_exitActionPerformed
        //Menu Exit
        int n = JOptionPane.showConfirmDialog(null,"Exit?" , "Exit", JOptionPane.YES_NO_OPTION);
        if(n==0)
        {
            System.exit(1);
        }
    }//GEN-LAST:event_menu_file_exitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Closing Window
        int n = JOptionPane.showConfirmDialog(null,"Exit?" , "Exit", JOptionPane.YES_NO_OPTION);
        if(n==0)
        {
            System.exit(1);
        }
    }//GEN-LAST:event_formWindowClosing

    private void menu_file_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_file_loadActionPerformed
        //Menu Load Animation File
        int n = JOptionPane.showConfirmDialog(null,"Any unsaved work will be lost\nLoad new Animation?" , "Load", JOptionPane.YES_NO_OPTION);
	if(n==0)
	{
            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
            chooser.setDialogTitle("Open File");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showOpenDialog(null);
            File f=chooser.getSelectedFile();
            if(f!=null)
            {
                Ganimator.data_arg_string=f.getAbsolutePath();
                Ganimator.data_operation=Operation.LoadFile;
            }
        }
    }//GEN-LAST:event_menu_file_loadActionPerformed

    private void menu_file_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_file_saveActionPerformed
        //Menu Save Animation File
        try
        {
          JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
          chooser.setDialogTitle("Open File");
          chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
          chooser.showOpenDialog(null);
          Ganimator.animation.saveFileV2(chooser.getSelectedFile().getAbsolutePath());
          JOptionPane.showMessageDialog(null, chooser.getSelectedFile().getAbsolutePath() +" file Saved!");
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null, "Failed to Save File\n("+e+")");
        }
    }//GEN-LAST:event_menu_file_saveActionPerformed

    private void play_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_buttonActionPerformed
        //Set animation_playing to true
        Ganimator.animation_playing=!Ganimator.animation_playing;
        if(Ganimator.animation_playing)
        {
            time_slider.setEnabled(false);
            time_slider.setFocusable(false);
            play_button.setText("Pause");
            Ganimator.bone_selected=false;
            Ganimator.working_bone=null;
            updateInterface();
        }
        else
        {
            time_slider.setEnabled(true);
            time_slider.setFocusable(true);
            play_button.setText("Play");
        }
    }//GEN-LAST:event_play_buttonActionPerformed

    private void time_sliderPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_time_sliderPropertyChange
        //Time slider prop change
        Ganimator.setAnimationTime(getTimeBarTime());
    }//GEN-LAST:event_time_sliderPropertyChange

    private void new_size_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_size_xActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_size_xActionPerformed

    private void bone_loop_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bone_loop_modeActionPerformed
        //Bone Loop Mode Toggle
        if(Ganimator.bone_selected && Ganimator.working_bone.length==1)
        {
            Ganimator.animation.getBones()[Ganimator.working_bone[0]].loop=!Ganimator.animation.getBones()[Ganimator.working_bone[0]].loop;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select Working Bone First");
        }
    }//GEN-LAST:event_bone_loop_modeActionPerformed

    private void new_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_addActionPerformed
        //Add new Bone to Animation
        try
        {
            String[] a = new String[1];
            a[0]=new_texture.getSelectedObjects()[0].toString();
            Ganimator.animation.addBone(a,Interface.new_label.getText(),0f,0f,Float.parseFloat(Interface.new_size_x.getText()),Float.parseFloat(Interface.new_size_y.getText()),Float.parseFloat(Interface.new_ori_x.getText()),Float.parseFloat(Interface.new_ori_y.getText()),Float.parseFloat(Interface.new_rotation.getText()),Interface.new_loop.isSelected(),Float.parseFloat(Interface.new_alpha.getText()));
            new_label.setText("bone");
            new_size_x.setText("0");
            new_size_y.setText("0");
            new_ori_x.setText("0");
            new_ori_y.setText("0");
            new_alpha.setText("1.0");
            new_rotation.setText("0");
            bone_add_frame.setVisible(false);
            this.setEnabled(true);
            this.requestFocus();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Check Values");
        }
        updateInterface();
    }//GEN-LAST:event_new_addActionPerformed

    private void new_labelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_labelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_labelActionPerformed

    private void bone_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bone_deleteActionPerformed
        //Delete Selected Bone
        if(Ganimator.bone_selected)
        {
            int i=0;
            while(i<Ganimator.working_bone.length)
            {
                Ganimator.animation.deleteBone(Ganimator.working_bone[i]);
                i++;
            }
            
            Ganimator.bone_selected=false;
            Ganimator.working_bone=null;
            working_bone_selector.setSelectedIndex(-1);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select Working Bone First");
        }
        updateInterface();
    }//GEN-LAST:event_bone_deleteActionPerformed

    private void bone_edit_frame_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bone_edit_frame_okActionPerformed
        //Ok Button on Bone Edit Frame Set Values and set invisible
        if(Ganimator.working_bone.length>0 && (bone_edit_label.getText()!=null && !bone_edit_label.getText().equals("")))
        {
            Ganimator.animation.getBones()[Ganimator.working_bone[0]].label=bone_edit_label.getText();
        }
        bone_edit_frame.setVisible(false);
        this.setEnabled(true);
        this.requestFocus();
        updateInterface();
    }//GEN-LAST:event_bone_edit_frame_okActionPerformed

    private void menu_settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_settingsActionPerformed
        //Menu Settigs
        updateSettingsFrame();
        settings_frame.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_menu_settingsActionPerformed

    private void settings_frame_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settings_frame_okActionPerformed
        //Settings Frame Ok Button
        try
        {
            Configuration.saveConfigFile(new File("config"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Writting Config File ("+e+")");
        }
        settings_frame.setVisible(false);
        this.setEnabled(true);
        this.requestFocus();
    }//GEN-LAST:event_settings_frame_okActionPerformed

    private void texture_directorie_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texture_directorie_changeActionPerformed
        //Choose Texture Directory
        try
        {
            settings_frame.setAlwaysOnTop(false);
            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
            chooser.setDialogTitle("Open Folder");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.showOpenDialog(null);
            String temp=chooser.getSelectedFile().getAbsolutePath();
            if(!temp.endsWith("\\"))
            {
                temp=temp+"\\";
            }
            Ganimator.texture_manager.setTexturePath(temp);
            Ganimator.data_operation=Operation.ReloadTextures;
            texture_directorie.setText(temp);
            Configuration.texture_path=temp;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed set Textures Folder Path\n("+e+")");
        }
        settings_frame.setAlwaysOnTop(true);
    }//GEN-LAST:event_texture_directorie_changeActionPerformed

    private void bone_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bone_editActionPerformed
        //Edit Selected Bone
        if(working_bone_selector.getSelectedIndex()!=-1)
        {
            updateBoneEditFrame();
            bone_edit_frame.setVisible(true);
            this.setEnabled(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select a bone first!");
        }
    }//GEN-LAST:event_bone_editActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Add new Bone Button
        bone_add_frame.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //New Bone Frame Cancel Button
        new_label.setText("bone");
        new_size_x.setText("0");
        new_size_y.setText("0");
        new_ori_x.setText("0");
        new_ori_y.setText("0");
        new_alpha.setText("1.0");
        new_rotation.setText("0");
        bone_add_frame.setVisible(false);
        this.setEnabled(true);
        this.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void menu_editor_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_editor_aboutActionPerformed
        //Show About Window
        about_frame.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_menu_editor_aboutActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Add new Frame to Working Bone
        if(working_bone_selector.getSelectedIndex()!=-1)
        {
            frame_add_frame.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select a bone first!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void animation_speedPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_animation_speedPropertyChange

    }//GEN-LAST:event_animation_speedPropertyChange

    private void menu_export_image_sequenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_export_image_sequenceActionPerformed
        //Export Image Menu Option
        export_image_sequence_frame.setVisible(true);
    }//GEN-LAST:event_menu_export_image_sequenceActionPerformed

    private void frame_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frame_deleteActionPerformed
        //Delete Frame
        if(!Ganimator.bone_selected || Ganimator.working_bone.length!=1)
        {
            JOptionPane.showMessageDialog(null, "Select One Bone First!");
        }
        else if(Ganimator.animation_playing)
        {
            JOptionPane.showMessageDialog(null, "Pause Animation First");
        }
        else if(frame_selector.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null, "Select a Frame first!");
        }
        else
        {
            if(!Ganimator.animation.bone[Ganimator.working_bone[0]].deleteKeyFrame(frame_selector.getSelectedIndex()))
            {
                JOptionPane.showMessageDialog(null, "Cant Delete Frame!");
            }
            Ganimator.animation.setTime(Ganimator.animation.getTime());
        }
        
        updateInterface();
    }//GEN-LAST:event_frame_deleteActionPerformed

    private void add_frame_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_frame_addActionPerformed
        //Add new Frame to a bone with selected time
        try
        {
            if(!Ganimator.bone_selected || Ganimator.working_bone.length!=1)
            {
                JOptionPane.showMessageDialog(null, "Select Bone First!");
            }
            else if(Ganimator.animation_playing)
            {
                JOptionPane.showMessageDialog(null, "Pause Animation First");
            }
            else
            {
            	Frame temp=Ganimator.animation.getBones()[Ganimator.working_bone[0]].getKeyFrame()[Ganimator.animation.getBones()[Ganimator.working_bone[0]].getKeyFrame().length-1];
                Ganimator.animation.getBones()[Ganimator.working_bone[0]].addKeyFrame(Float.parseFloat(add_frame_time.getText()),  temp.pos.x,  temp.pos.y,  temp.size.x, temp.size.y, temp.ori.x, temp.ori.y, temp.rotation, temp.alpha,0);
                frame_add_frame.setVisible(false);
                this.requestFocus();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Check your values");
        }
        updateInterface();
    }//GEN-LAST:event_add_frame_addActionPerformed

    private void add_frame_timeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_frame_timeKeyPressed
        //Key Enter Pressd on add frame frame
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            //Add new bone with selected time
            try
            {
                if(Ganimator.bone_selected)
                {
                    JOptionPane.showMessageDialog(null, "Select a Bone First!");
                }
                else if(Ganimator.animation_playing)
                {
                    JOptionPane.showMessageDialog(null, "Pause Animation First");
                }
                else
                {
                    Frame temp=Ganimator.animation.getBones()[Ganimator.working_bone[0]].getKeyFrame()[Ganimator.animation.getBones()[Ganimator.working_bone[0]].getKeyFrame().length-1];
                    Ganimator.animation.getBones()[Ganimator.working_bone[0]].addKeyFrame(Float.parseFloat(add_frame_time.getText()),  temp.pos.x,  temp.pos.y,  temp.size.x, temp.size.y, temp.ori.x, temp.ori.y, temp.rotation, temp.alpha,0);
                    frame_add_frame.setVisible(false);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Check your values");
            }
            updateInterface();
        }
    }//GEN-LAST:event_add_frame_timeKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Edit Frame Manually
        if(!Ganimator.bone_selected)
        {
            JOptionPane.showMessageDialog(null, "Select a Bone First!");
        }
        else if(frame_selector.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null, "Select a Frame first!");
        }
        else if(Ganimator.animation_playing)
        {
            JOptionPane.showMessageDialog(null, "Pause Animation First");
        }
        else
        {
            frame_edit_frame.setVisible(true);
            this.setEnabled(false);
            int i=frame_selector.getSelectedIndex();
            edit_size_x.setText(Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].size.x+"");
            edit_size_y.setText(Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].size.y+"");
            edit_pos_x.setText(Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].pos.x+"");
            edit_pos_y.setText(Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].pos.y+"");
            edit_ori_x.setText(Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].ori.x+"");
            edit_ori_y.setText(Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].ori.y+"");
            edit_alpha.setText(Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].alpha+"");
            edit_rotation.setText(Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].rotation+"");
            
            //TODO Check why makind second validation here
            if(Ganimator.bone_selected)
            {
                String temp=Ganimator.animation.getBones()[Ganimator.working_bone[0]].texture_file[Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].texture];
                int j=0;
                while(j<edit_texture.getItemCount())
                {
                    if(edit_texture.getItemAt(j).equals(temp))
                    {
                        edit_texture.setSelectedIndex(j);
                        break;
                    }
                    j++;
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void edit_size_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_size_xActionPerformed

    }//GEN-LAST:event_edit_size_xActionPerformed

    private void edit_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_cancelActionPerformed
       frame_edit_frame.setVisible(false);
       this.setEnabled(true);
       this.requestFocus();
    }//GEN-LAST:event_edit_cancelActionPerformed

    private void edit_okayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_okayActionPerformed
        //Ok Buton on frame edit frame
        int i=frame_selector.getSelectedIndex();
        Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].size.x=Float.parseFloat(edit_size_x.getText());
        Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].size.y=Float.parseFloat(edit_size_y.getText());
        Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].pos.x=Float.parseFloat(edit_pos_x.getText());
        Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].pos.y=Float.parseFloat(edit_pos_y.getText());
        Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].ori.x=Float.parseFloat(edit_ori_x.getText());
        Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].ori.y=Float.parseFloat(edit_ori_y.getText());
        Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].alpha=Float.parseFloat(edit_alpha.getText());
        Ganimator.animation.bone[Ganimator.working_bone[0]].key_frame[i].rotation=Float.parseFloat(edit_rotation.getText());
        Ganimator.animation.bone[Ganimator.working_bone[0]].setTexture(Ganimator.texture_manager.getTextureList()[edit_texture.getSelectedIndex()],i);
        frame_edit_frame.setVisible(false);
        this.setEnabled(true);
        this.requestFocus();
    }//GEN-LAST:event_edit_okayActionPerformed

    private void bone_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bone_upActionPerformed
        //Move Bone Up
        if(!Ganimator.bone_selected || Ganimator.working_bone.length!=1)
        {
            JOptionPane.showMessageDialog(null, "Select One Bone First!");
        }
        else if(working_bone_selector.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Cant Move This Bone");
        }
        else
        {
            int index=working_bone_selector.getSelectedIndex();
            Ganimator.animation.moveBoneDown(index);
            updateBoneList();
            working_bone_selector.setSelectedIndex(index-1);
            
            Ganimator.working_bone=working_bone_selector.getSelectedIndices();
            Ganimator.bone_selected=true;
        }
    }//GEN-LAST:event_bone_upActionPerformed

    private void bone_downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bone_downActionPerformed
        //Move Bone Down
        if(!Ganimator.bone_selected || Ganimator.working_bone.length!=1)
        {
            JOptionPane.showMessageDialog(null, "Select One Bone First!");
        }
        else if(working_bone_selector.getSelectedIndex()==Ganimator.animation.bone.length-1)
        {
            JOptionPane.showMessageDialog(null, "Cant Move This Bone");
        }
        else
        {
            int index=working_bone_selector.getSelectedIndex();
            Ganimator.animation.moveBoneUp(index);
            updateBoneList();
            working_bone_selector.setSelectedIndex(index+1);
            
            Ganimator.working_bone=working_bone_selector.getSelectedIndices();
            Ganimator.bone_selected=true;
        }
    }//GEN-LAST:event_bone_downActionPerformed

    private void about_frameComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_about_frameComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_about_frameComponentShown

    private void settings_fps_lockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settings_fps_lockActionPerformed
        Configuration.fps_lock=settings_fps_lock.getSelectedIndex();
    }//GEN-LAST:event_settings_fps_lockActionPerformed

    private void menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseEntered
        //TODO DELETE
    }//GEN-LAST:event_menuMouseEntered

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked

    }//GEN-LAST:event_menuMouseClicked

    private void working_bone_selectorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_working_bone_selectorValueChanged
        //Change Working Bone(Mouse Pressed Event)
        Ganimator.working_bone=working_bone_selector.getSelectedIndices();
        Ganimator.bone_selected=true;
        
        //Update Interface Elements
        setTimeBarTime();
        updateTimeBar();
        updateFrameList();
    }//GEN-LAST:event_working_bone_selectorValueChanged

    private void about_frameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_about_frameWindowClosing
        about_frame.setVisible(false);
        this.setEnabled(true);
        this.requestFocus();
    }//GEN-LAST:event_about_frameWindowClosing

    private void frame_selectorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_frame_selectorValueChanged
        //Select Frame and change time to that frame time
        int index=frame_selector.getSelectedIndex();
    	if(index!=-1)
    	{
            Ganimator.setAnimationTime(Ganimator.animation.getBones()[Ganimator.working_bone[0]].getKeyFrame()[index].time);
    	}
        frame_selector.setSelectedIndex(index);
        updateTimeBar();
    }//GEN-LAST:event_frame_selectorValueChanged

    private void explorer_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explorer_positionActionPerformed
        Configuration.explorer_pos=explorer_position.getSelectedIndex();
    }//GEN-LAST:event_explorer_positionActionPerformed

    private void containerComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_containerComponentResized
        //Windows Resized Event
        try
        {
            Ganimator.canvas.getCanvas().setSize(Interface.container.size().width,Interface.container.size().height);
            Ganimator.setCameraSize(Interface.container.size().width,Interface.container.size().height);
            Ganimator.iniOverlay(Interface.container.size().width,Interface.container.size().height);
        }
        catch(Exception e)
        {}
    }//GEN-LAST:event_containerComponentResized

    private void texture_directorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texture_directorieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texture_directorieActionPerformed

    private void dialog_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dialog_noActionPerformed

    private void animation_speedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_animation_speedStateChanged
        //Animation Speed Change Bar
        float speed=animation_speed.getValue()/100f;
        animation_speed_indicator.setText(speed+"x");
        Ganimator.animation_play_speed=speed;
    }//GEN-LAST:event_animation_speedStateChanged

    private void bone_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bone_edit1ActionPerformed
        //Clone Selected Bone
        if(working_bone_selector.getSelectedIndex()!=-1)
        {
            Ganimator.animation.cloneBone(working_bone_selector.getSelectedIndex());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select a bone first!");
        }
    }//GEN-LAST:event_bone_edit1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel about_email;
    private javax.swing.JFrame about_frame;
    private javax.swing.JLabel about_ganimator_logo;
    private javax.swing.JLabel about_ganimator_version;
    private javax.swing.JLabel about_libgdx_logo;
    private javax.swing.JLabel about_title;
    private javax.swing.JButton add_frame_add;
    private javax.swing.JTextField add_frame_time;
    private javax.swing.JSlider animation_speed;
    private javax.swing.JLabel animation_speed_indicator;
    private javax.swing.JFrame bone_add_frame;
    public static javax.swing.JButton bone_delete;
    private javax.swing.JButton bone_down;
    private javax.swing.JButton bone_edit;
    private javax.swing.JButton bone_edit1;
    public static javax.swing.JFrame bone_edit_frame;
    private javax.swing.JButton bone_edit_frame_ok;
    static javax.swing.JTextField bone_edit_label;
    public static javax.swing.JCheckBox bone_loop_mode;
    private javax.swing.JButton bone_up;
    public static java.awt.Panel container;
    private javax.swing.JFrame dialog_frame;
    private javax.swing.JLabel dialog_message;
    private javax.swing.JButton dialog_no;
    private javax.swing.JPanel dialog_panel;
    private javax.swing.JButton dialog_yes;
    public static javax.swing.JTextField edit_alpha;
    private javax.swing.JButton edit_cancel;
    public static javax.swing.JButton edit_okay;
    public static javax.swing.JTextField edit_ori_x;
    public static javax.swing.JTextField edit_ori_y;
    public static javax.swing.JTextField edit_pos_x;
    public static javax.swing.JTextField edit_pos_y;
    public static javax.swing.JTextField edit_rotation;
    public static javax.swing.JTextField edit_size_x;
    public static javax.swing.JTextField edit_size_y;
    static javax.swing.JComboBox edit_texture;
    private javax.swing.JFrame error_frame;
    private javax.swing.JLabel error_message;
    private javax.swing.JButton error_okay;
    private javax.swing.JPanel error_panel;
    static javax.swing.JComboBox explorer_position;
    private javax.swing.JComboBox export_format;
    private javax.swing.JTextField export_fps;
    private javax.swing.JFrame export_image_sequence_frame;
    private javax.swing.JPanel export_image_sequence_panel;
    private javax.swing.JFrame frame_add_frame;
    private javax.swing.JButton frame_delete;
    private javax.swing.JFrame frame_edit_frame;
    public static javax.swing.JList frame_selector;
    private javax.swing.JScrollPane frame_selector_box;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    public static javax.swing.JLabel jLabel25;
    public static javax.swing.JLabel jLabel26;
    public static javax.swing.JLabel jLabel27;
    public static javax.swing.JLabel jLabel28;
    public static javax.swing.JLabel jLabel29;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JMenuBar menu;
    public static javax.swing.JMenu menu_about;
    public static javax.swing.JMenuItem menu_editor_about;
    private javax.swing.JMenuItem menu_export_image_sequence;
    public static javax.swing.JMenu menu_file;
    private javax.swing.JMenuItem menu_file_exit;
    private javax.swing.JMenu menu_file_export;
    private javax.swing.JMenuItem menu_file_load;
    private javax.swing.JMenuItem menu_file_new;
    private javax.swing.JMenuItem menu_file_save;
    private javax.swing.JMenuItem menu_settings;
    public static javax.swing.JButton new_add;
    public static javax.swing.JTextField new_alpha;
    public static javax.swing.JTextField new_label;
    public static javax.swing.JCheckBox new_loop;
    public static javax.swing.JTextField new_ori_x;
    public static javax.swing.JTextField new_ori_y;
    public static javax.swing.JTextField new_rotation;
    public static javax.swing.JTextField new_size_x;
    public static javax.swing.JTextField new_size_y;
    public static javax.swing.JComboBox new_texture;
    public static javax.swing.JPanel panel_explorer;
    public static javax.swing.JPanel panel_frame;
    public static javax.swing.JButton play_button;
    private javax.swing.JSeparator separador;
    private static javax.swing.JComboBox settings_fps_lock;
    private javax.swing.JFrame settings_frame;
    private javax.swing.JButton settings_frame_ok;
    static javax.swing.JSplitPane split_pane;
    public static javax.swing.JTextField texture_directorie;
    public static javax.swing.JButton texture_directorie_change;
    public static javax.swing.JSlider time_slider;
    static javax.swing.JList working_bone_selector;
    public static javax.swing.JScrollPane working_bone_selector_box;
    public static javax.swing.JLabel working_bone_selector_text;
    // End of variables declaration//GEN-END:variables
}
