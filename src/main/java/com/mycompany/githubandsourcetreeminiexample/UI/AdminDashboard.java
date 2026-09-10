/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.githubandsourcetreeminiexample.UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class AdminDashboard extends JFrame{


    // Main panels
    private JPanel sidebarPanel;
    private JPanel contentPanel;

    // Colors
    private final Color SIDEBAR_COLOR = new Color(15, 23, 42);
    private final Color SIDEBAR_HOVER = new Color(30, 41, 59);
    private final Color BACKGROUND_COLOR = new Color(248, 250, 252);
    private final Color TEXT_COLOR = new Color(15, 23, 42);
    private final Color SECONDARY_TEXT = new Color(100, 116, 139);
    private final Color CARD_COLOR = Color.WHITE;

    public AdminDashboard() {
        initComponents();
        showDashboard();
    }

    private void initComponents() {

        setTitle("Library Management System - Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // =====================================================
        // SIDEBAR
        // =====================================================

        sidebarPanel = new JPanel();
        sidebarPanel.setPreferredSize(new Dimension(235, 750));
        sidebarPanel.setBackground(SIDEBAR_COLOR);
        sidebarPanel.setLayout(new BorderLayout());

        // -----------------------------------------------------
        // LOGO
        // -----------------------------------------------------

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(SIDEBAR_COLOR);
        logoPanel.setBorder(
                new EmptyBorder(25, 20, 20, 20)
        );

        logoPanel.setLayout(
                new BorderLayout()
        );

        JLabel logoLabel =
                new JLabel("Library System");

        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        JLabel roleLabel =
                new JLabel("Administrator");

        roleLabel.setForeground(
                new Color(148, 163, 184)
        );

        roleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        JPanel logoText = new JPanel();

        logoText.setOpaque(false);

        logoText.setLayout(
                new BoxLayout(
                        logoText,
                        BoxLayout.Y_AXIS
                )
        );

        logoText.add(logoLabel);
        logoText.add(
                Box.createVerticalStrut(5)
        );
        logoText.add(roleLabel);

        logoPanel.add(
                logoText,
                BorderLayout.WEST
        );

        sidebarPanel.add(
                logoPanel,
                BorderLayout.NORTH
        );

        // =====================================================
        // MENU
        // =====================================================

        JPanel menuPanel = new JPanel();

        menuPanel.setBackground(
                SIDEBAR_COLOR
        );

        menuPanel.setBorder(
                new EmptyBorder(
                        10,
                        12,
                        10,
                        12
                )
        );

        menuPanel.setLayout(
                new BoxLayout(
                        menuPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JButton dashboardButton =
                createMenuButton("Dashboard");

        JButton usersButton =
                createMenuButton("User Accounts");

        JButton rolesButton =
                createMenuButton("Roles");

        JButton permissionsButton =
                createMenuButton("Permissions");

        JButton auditButton =
                createMenuButton("Audit Logs");

        JButton settingsButton =
                createMenuButton("Settings");

        JButton backupButton =
                createMenuButton("Backup / Restore");

        JButton reportsButton =
                createMenuButton("System Reports");

        // Add buttons
        menuPanel.add(dashboardButton);
        menuPanel.add(usersButton);
        menuPanel.add(rolesButton);
        menuPanel.add(permissionsButton);
        menuPanel.add(auditButton);
        menuPanel.add(settingsButton);
        menuPanel.add(backupButton);
        menuPanel.add(reportsButton);

        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        dashboardButton.addActionListener(
                e -> showDashboard()
        );

        usersButton.addActionListener(
                e -> showUsers()
        );

        rolesButton.addActionListener(
                e -> showRoles()
        );

        permissionsButton.addActionListener(
                e -> showPermissions()
        );

        auditButton.addActionListener(
                e -> showAuditLogs()
        );

        settingsButton.addActionListener(
                e -> showSettings()
        );

        backupButton.addActionListener(
                e -> showBackupRestore()
        );

        reportsButton.addActionListener(
                e -> showReports()
        );

        sidebarPanel.add(
                menuPanel,
                BorderLayout.CENTER
        );

        // =====================================================
        // LOGOUT
        // =====================================================

        JPanel bottomPanel =
                new JPanel(
                        new BorderLayout()
                );

        bottomPanel.setBackground(
                SIDEBAR_COLOR
        );

        bottomPanel.setBorder(
                new EmptyBorder(
                        10,
                        12,
                        20,
                        12
                )
        );

        JButton logoutButton =
                createMenuButton("Logout");

        logoutButton.addActionListener(
                e -> {

                    int result =
                            JOptionPane.showConfirmDialog(
                                    this,
                                    "Are you sure you want to logout?",
                                    "Logout",
                                    JOptionPane.YES_NO_OPTION
                            );

                    if (result ==
                            JOptionPane.YES_OPTION) {

                        dispose();

                        // Open LoginForm later
                        // new LoginForm().setVisible(true);
                    }
                }
        );

        bottomPanel.add(
                logoutButton,
                BorderLayout.CENTER
        );

        sidebarPanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // =====================================================
        // CONTENT
        // =====================================================

        contentPanel = new JPanel();

        contentPanel.setBackground(
                BACKGROUND_COLOR
        );

        contentPanel.setLayout(
                new BorderLayout()
        );

        add(
                sidebarPanel,
                BorderLayout.WEST
        );

        add(
                contentPanel,
                BorderLayout.CENTER
        );
    }

    // =========================================================
    // MENU BUTTON
    // =========================================================

    private JButton createMenuButton(
            String text) {

        JButton button =
                new JButton(text);

        button.setMaximumSize(
                new Dimension(
                        210,
                        45
                )
        );

        button.setPreferredSize(
                new Dimension(
                        210,
                        45
                )
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                SIDEBAR_COLOR
        );

        button.setBorder(
                new EmptyBorder(
                        10,
                        15,
                        10,
                        10
                )
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);

        button.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e) {

                        button.setBackground(
                                SIDEBAR_HOVER
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e) {

                        button.setBackground(
                                SIDEBAR_COLOR
                        );
                    }
                }
        );

        return button;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private JPanel createHeader(
            String title,
            String subtitle) {

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(
                Color.WHITE
        );

        header.setBorder(
                new EmptyBorder(
                        20,
                        30,
                        20,
                        30
                )
        );

        JPanel titlePanel =
                new JPanel();

        titlePanel.setOpaque(false);

        titlePanel.setLayout(
                new BoxLayout(
                        titlePanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        26
                )
        );

        titleLabel.setForeground(
                TEXT_COLOR
        );

        JLabel subtitleLabel =
                new JLabel(subtitle);

        subtitleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        subtitleLabel.setForeground(
                SECONDARY_TEXT
        );

        titlePanel.add(titleLabel);

        titlePanel.add(
                Box.createVerticalStrut(5)
        );

        titlePanel.add(subtitleLabel);

        JLabel adminLabel =
                new JLabel("Administrator");

        adminLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        adminLabel.setForeground(
                TEXT_COLOR
        );

        header.add(
                titlePanel,
                BorderLayout.WEST
        );

        header.add(
                adminLabel,
                BorderLayout.EAST
        );

        return header;
    }

    // =========================================================
    // DASHBOARD
    // =========================================================

    private void showDashboard() {

        contentPanel.removeAll();

        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(
                BACKGROUND_COLOR
        );

        main.add(
                createHeader(
                        "Admin Dashboard",
                        "Manage and monitor the library system"
                ),
                BorderLayout.NORTH
        );

        JPanel center =
                new JPanel();

        center.setBackground(
                BACKGROUND_COLOR
        );

        center.setBorder(
                new EmptyBorder(
                        25,
                        30,
                        25,
                        30
                )
        );

        center.setLayout(
                new BoxLayout(
                        center,
                        BoxLayout.Y_AXIS
                )
        );

        // =====================================================
        // CARDS
        // =====================================================

        JPanel cardsPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                20,
                                20
                        )
                );

        cardsPanel.setOpaque(false);

        cardsPanel.add(
                createCard(
                        "Total Users",
                        "250",
                        "Registered accounts"
                )
        );

        cardsPanel.add(
                createCard(
                        "Librarians",
                        "8",
                        "Active librarians"
                )
        );

        cardsPanel.add(
                createCard(
                        "Admins",
                        "2",
                        "System administrators"
                )
        );

        cardsPanel.add(
                createCard(
                        "Audit Events",
                        "1,428",
                        "Recorded activities"
                )
        );

        center.add(cardsPanel);

        center.add(
                Box.createVerticalStrut(30)
        );

        JLabel activityLabel =
                new JLabel(
                        "Recent System Activities"
                );

        activityLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        19
                )
        );

        activityLabel.setForeground(
                TEXT_COLOR
        );

        center.add(activityLabel);

        center.add(
                Box.createVerticalStrut(12)
        );

        // =====================================================
        // ACTIVITY TABLE
        // =====================================================

        String[] columns = {
            "User",
            "Role",
            "Activity",
            "Date",
            "Status"
        };

        Object[][] data = {

            {
                "Admin",
                "Administrator",
                "Updated system settings",
                "2026-09-09",
                "Success"
            },

            {
                "Librarian01",
                "Librarian",
                "Issued a book",
                "2026-09-09",
                "Success"
            },

            {
                "Admin",
                "Administrator",
                "Created librarian account",
                "2026-09-08",
                "Success"
            },

            {
                "Librarian02",
                "Librarian",
                "Returned a book",
                "2026-09-08",
                "Success"
            }
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(
                                data,
                                columns
                        ) {

                            @Override
                            public boolean isCellEditable(
                                    int row,
                                    int column) {

                                return false;
                            }
                        }
                );

        table.setRowHeight(35);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        table.getTableHeader()
                .setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                13
                        )
                );

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setPreferredSize(
                new Dimension(
                        900,
                        250
                )
        );

        center.add(scrollPane);

        main.add(
                center,
                BorderLayout.CENTER
        );

        contentPanel.add(main);

        refresh();
    }

    // =========================================================
    // CARD
    // =========================================================

    private JPanel createCard(
            String title,
            String value,
            String description) {

        JPanel card =
                new JPanel();

        card.setBackground(
                CARD_COLOR
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        226,
                                        232,
                                        240
                                )
                        ),
                        new EmptyBorder(
                                20,
                                20,
                                20,
                                20
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        titleLabel.setForeground(
                SECONDARY_TEXT
        );

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        valueLabel.setForeground(
                TEXT_COLOR
        );

        JLabel descriptionLabel =
                new JLabel(description);

        descriptionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        descriptionLabel.setForeground(
                SECONDARY_TEXT
        );

        card.add(titleLabel);

        card.add(
                Box.createVerticalStrut(8)
        );

        card.add(valueLabel);

        card.add(
                Box.createVerticalStrut(5)
        );

        card.add(descriptionLabel);

        return card;
    }

    // =========================================================
    // USER ACCOUNTS
    // =========================================================

    private void showUsers() {

        contentPanel.removeAll();

        JPanel panel =
                createOperationPanel(
                        "User Accounts",
                        "Create, update and manage system user accounts"
                );

        JPanel top =
                new JPanel(
                        new BorderLayout(
                                10,
                                10
                        )
                );

        top.setOpaque(false);

        JTextField searchField =
                new JTextField();

        searchField.setPreferredSize(
                new Dimension(
                        300,
                        40
                )
        );

        JButton searchButton =
                new JButton("Search");

        JButton addButton =
                new JButton("Add User");

        top.add(
                searchField,
                BorderLayout.CENTER
        );

        top.add(
                searchButton,
                BorderLayout.EAST
        );

        top.add(
                addButton,
                BorderLayout.WEST
        );

        panel.add(
                top,
                BorderLayout.NORTH
        );

        String[] columns = {
            "User ID",
            "Name",
            "Email",
            "Role",
            "Status"
        };

        Object[][] data = {

            {
                "U001",
                "Admin",
                "admin@library.com",
                "Administrator",
                "Active"
            },

            {
                "U002",
                "Mg Mg",
                "mgmg@library.com",
                "Librarian",
                "Active"
            },

            {
                "U003",
                "Su Su",
                "susu@library.com",
                "Librarian",
                "Active"
            }
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(
                                data,
                                columns
                        )
                );

        table.setRowHeight(35);

        panel.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // ROLES
    // =========================================================

    private void showRoles() {

        contentPanel.removeAll();

        JPanel panel =
                createOperationPanel(
                        "Roles",
                        "Manage system roles"
                );

        String[] columns = {
            "Role ID",
            "Role Name",
            "Description",
            "Status"
        };

        Object[][] data = {

            {
                "1",
                "Administrator",
                "Full system management",
                "Active"
            },

            {
                "2",
                "Librarian",
                "Daily library operations",
                "Active"
            },

            {
                "3",
                "Member",
                "Access member functions",
                "Active"
            }
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(
                                data,
                                columns
                        )
                );

        table.setRowHeight(35);

        panel.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // PERMISSIONS
    // =========================================================

    private void showPermissions() {

        contentPanel.removeAll();

        JPanel panel =
                createOperationPanel(
                        "Permissions",
                        "Control what each role can access"
                );

        String[] columns = {
            "Permission",
            "Administrator",
            "Librarian",
            "Member"
        };

        Object[][] data = {

            {
                "Manage Users",
                "Yes",
                "No",
                "No"
            },

            {
                "Manage Roles",
                "Yes",
                "No",
                "No"
            },

            {
                "Issue Books",
                "Yes",
                "Yes",
                "No"
            },

            {
                "Return Books",
                "Yes",
                "Yes",
                "No"
            },

            {
                "Reserve Books",
                "Yes",
                "Yes",
                "Yes"
            },

            {
                "System Settings",
                "Yes",
                "No",
                "No"
            }
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(
                                data,
                                columns
                        )
                );

        table.setRowHeight(35);

        panel.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // AUDIT LOGS
    // =========================================================

    private void showAuditLogs() {

        contentPanel.removeAll();

        JPanel panel =
                createOperationPanel(
                        "Audit Logs",
                        "Track important activities performed in the system"
                );

        String[] columns = {
            "Log ID",
            "User",
            "Action",
            "Module",
            "Date",
            "Result"
        };

        Object[][] data = {

            {
                "L001",
                "Admin",
                "Login",
                "Authentication",
                "2026-09-09 08:30",
                "Success"
            },

            {
                "L002",
                "Admin",
                "Create User",
                "User Management",
                "2026-09-09 09:10",
                "Success"
            },

            {
                "L003",
                "Librarian01",
                "Issue Book",
                "Borrowing",
                "2026-09-09 10:20",
                "Success"
            },

            {
                "L004",
                "Admin",
                "Update Settings",
                "Settings",
                "2026-09-09 11:00",
                "Success"
            }
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(
                                data,
                                columns
                        )
                );

        table.setRowHeight(35);

        panel.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // SETTINGS
    // =========================================================

    private void showSettings() {

        contentPanel.removeAll();

        JPanel panel =
                createOperationPanel(
                        "System Settings",
                        "Configure library system settings"
                );

        JPanel form =
                new JPanel(
                        new GridLayout(
                                0,
                                2,
                                15,
                                15
                        )
                );

        form.setBackground(Color.WHITE);

        form.setBorder(
                new EmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );

        form.add(
                createLabel("Library Name")
        );

        form.add(
                new JTextField(
                        "Library Management System"
                )
        );

        form.add(
                createLabel("Loan Period")
        );

        form.add(
                new JTextField(
                        "14 days"
                )
        );

        form.add(
                createLabel("Maximum Books")
        );

        form.add(
                new JTextField(
                        "5"
                )
        );

        form.add(
                createLabel("Fine Per Day")
        );

        form.add(
                new JTextField(
                        "1.00"
                )
        );

        JButton saveButton =
                new JButton("Save Settings");

        form.add(
                new JLabel("")
        );

        form.add(saveButton);

        saveButton.addActionListener(
                e -> JOptionPane.showMessageDialog(
                        this,
                        "Settings saved successfully."
                )
        );

        panel.add(
                form,
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // BACKUP / RESTORE
    // =========================================================

    private void showBackupRestore() {

        contentPanel.removeAll();

        JPanel panel =
                createOperationPanel(
                        "Backup / Restore",
                        "Protect and restore library system data"
                );

        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                15,
                                15
                        )
                );

        buttons.setOpaque(false);

        JButton backupButton =
                new JButton(
                        "Create Backup"
                );

        JButton restoreButton =
                new JButton(
                        "Restore Backup"
                );

        buttons.add(backupButton);
        buttons.add(restoreButton);

        backupButton.addActionListener(
                e -> JOptionPane.showMessageDialog(
                        this,
                        "Backup process started."
                )
        );

        restoreButton.addActionListener(
                e -> JOptionPane.showMessageDialog(
                        this,
                        "Restore process started."
                )
        );

        panel.add(
                buttons,
                BorderLayout.NORTH
        );

        JTextArea info =
                new JTextArea();

        info.setEditable(false);

        info.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        info.setText(
                "Database Backup\n\n"
                + "Last Backup : 2026-09-08\n"
                + "Database    : Library Management System\n"
                + "Status      : Available\n\n"
                + "Backup is used to protect system data."
        );

        panel.add(
                new JScrollPane(info),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // REPORTS
    // =========================================================

    private void showReports() {

        contentPanel.removeAll();

        JPanel panel =
                createOperationPanel(
                        "System Reports",
                        "View system-level information and statistics"
                );

        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                15,
                                15
                        )
                );

        buttons.setOpaque(false);

        JButton usersReport =
                new JButton(
                        "User Report"
                );

        JButton auditReport =
                new JButton(
                        "Audit Report"
                );

        JButton systemReport =
                new JButton(
                        "System Report"
                );

        buttons.add(usersReport);
        buttons.add(auditReport);
        buttons.add(systemReport);

        panel.add(
                buttons,
                BorderLayout.NORTH
        );

        JTextArea reportArea =
                new JTextArea();

        reportArea.setEditable(false);

        reportArea.setFont(
                new Font(
                        "Consolas",
                        Font.PLAIN,
                        14
                )
        );

        reportArea.setText(
                "Library System Report\n\n"
                + "Total Users       : 250\n"
                + "Administrators    : 2\n"
                + "Librarians        : 8\n"
                + "Members           : 240\n"
                + "Audit Events      : 1,428\n"
                + "System Status     : Running\n"
        );

        panel.add(
                new JScrollPane(reportArea),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // OPERATION PANEL
    // =========================================================

    private JPanel createOperationPanel(
            String title,
            String subtitle) {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBackground(
                BACKGROUND_COLOR
        );

        panel.add(
                createHeader(
                        title,
                        subtitle
                ),
                BorderLayout.NORTH
        );

        JPanel body =
                new JPanel(
                        new BorderLayout()
                );

        body.setBackground(
                BACKGROUND_COLOR
        );

        body.setBorder(
                new EmptyBorder(
                        25,
                        30,
                        25,
                        30
                )
        );

        panel.add(
                body,
                BorderLayout.CENTER
        );

        return panel;
    }

    // =========================================================
    // LABEL
    // =========================================================

    private JLabel createLabel(
            String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(
                TEXT_COLOR
        );

        return label;
    }

    // =========================================================
    // REFRESH
    // =========================================================

    private void refresh() {

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    try {

                        UIManager.setLookAndFeel(
                                UIManager
                                        .getSystemLookAndFeelClassName()
                        );

                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                    new AdminDashboard()
                            .setVisible(true);
                }
        );
    }
}

