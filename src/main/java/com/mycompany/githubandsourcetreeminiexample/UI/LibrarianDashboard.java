/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.githubandsourcetreeminiexample.UI;

/**
 *
 * @author Admin
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class LibrarianDashboard extends JFrame{

    // Main panels
    private JPanel sidebarPanel;
    private JPanel contentPanel;

    // Colors
    private final Color SIDEBAR_COLOR = new Color(30, 41, 59);
    private final Color SIDEBAR_HOVER = new Color(51, 65, 85);
    private final Color BACKGROUND_COLOR = new Color(248, 250, 252);
    private final Color TEXT_COLOR = new Color(15, 23, 42);
    private final Color SECONDARY_TEXT = new Color(100, 116, 139);
    private final Color CARD_COLOR = Color.WHITE;

    public LibrarianDashboard() {
        initComponents();
        showDashboard();
    }

    private void initComponents() {

        setTitle("Library Management System - Librarian Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // =========================
        // SIDEBAR
        // =========================
        sidebarPanel = new JPanel();
        sidebarPanel.setPreferredSize(new Dimension(230, 750));
        sidebarPanel.setBackground(SIDEBAR_COLOR);
        sidebarPanel.setLayout(new BorderLayout());

        // Logo / Title
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(SIDEBAR_COLOR);
        logoPanel.setBorder(new EmptyBorder(25, 20, 20, 20));
        logoPanel.setLayout(new BorderLayout());

        JLabel logoLabel = new JLabel("📚 Library");
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel roleLabel = new JLabel("Librarian Panel");
        roleLabel.setForeground(new Color(148, 163, 184));
        roleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        JPanel logoText = new JPanel();
        logoText.setOpaque(false);
        logoText.setLayout(new BoxLayout(logoText, BoxLayout.Y_AXIS));

        logoText.add(logoLabel);
        logoText.add(Box.createVerticalStrut(5));
        logoText.add(roleLabel);

        logoPanel.add(logoText, BorderLayout.WEST);

        sidebarPanel.add(logoPanel, BorderLayout.NORTH);

        // Menu
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(SIDEBAR_COLOR);
        menuPanel.setBorder(new EmptyBorder(10, 12, 10, 12));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JButton dashboardButton =
                createMenuButton("Dashboard");

        JButton booksButton =
                createMenuButton("Books / Catalogue");

        JButton issueButton =
                createMenuButton("Issue Book");

        JButton returnButton =
                createMenuButton("Return Book");

        JButton renewButton =
                createMenuButton("Renew Book");

        JButton reservationButton =
                createMenuButton("Reservations");

        JButton membersButton =
                createMenuButton("Members");

        JButton finesButton =
                createMenuButton("Fines");

        JButton notificationButton =
                createMenuButton("Notifications");

        JButton reportsButton =
                createMenuButton("Reports");

        menuPanel.add(dashboardButton);
        menuPanel.add(booksButton);
        menuPanel.add(issueButton);
        menuPanel.add(returnButton);
        menuPanel.add(renewButton);
        menuPanel.add(reservationButton);
        menuPanel.add(membersButton);
        menuPanel.add(finesButton);
        menuPanel.add(notificationButton);
        menuPanel.add(reportsButton);

        // Button actions
        dashboardButton.addActionListener(e -> showDashboard());
        booksButton.addActionListener(e -> showBooks());
        issueButton.addActionListener(e -> showIssueBook());
        returnButton.addActionListener(e -> showReturnBook());
        renewButton.addActionListener(e -> showRenewBook());
        reservationButton.addActionListener(e -> showReservations());
        membersButton.addActionListener(e -> showMembers());
        finesButton.addActionListener(e -> showFines());
        notificationButton.addActionListener(e -> showNotifications());
        reportsButton.addActionListener(e -> showReports());

        sidebarPanel.add(menuPanel, BorderLayout.CENTER);

        // Logout
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(SIDEBAR_COLOR);
        bottomPanel.setBorder(new EmptyBorder(10, 12, 20, 12));

        JButton logoutButton = createMenuButton("Logout");

        logoutButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                dispose();

                // Open LoginForm here later
                // new LoginForm().setVisible(true);
            }
        });

        bottomPanel.add(logoutButton, BorderLayout.CENTER);

        sidebarPanel.add(bottomPanel, BorderLayout.SOUTH);

        // =========================
        // CONTENT PANEL
        // =========================
        contentPanel = new JPanel();
        contentPanel.setBackground(BACKGROUND_COLOR);
        contentPanel.setLayout(new BorderLayout());

        add(sidebarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    // ============================================================
    // MENU BUTTON
    // ============================================================

    private JButton createMenuButton(String text) {

        JButton button = new JButton(text);

        button.setMaximumSize(new Dimension(205, 45));
        button.setPreferredSize(new Dimension(205, 45));

        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(SIDEBAR_COLOR);

        button.setBorder(new EmptyBorder(10, 15, 10, 10));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);

        button.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(SIDEBAR_HOVER);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(SIDEBAR_COLOR);
            }
        });

        return button;
    }

    // ============================================================
    // HEADER
    // ============================================================

    private JPanel createHeader(String title, String subtitle) {

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.setBorder(new EmptyBorder(20, 30, 20, 30));

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setForeground(TEXT_COLOR);

        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitleLabel.setForeground(SECONDARY_TEXT);

        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subtitleLabel);

        JLabel userLabel = new JLabel("Librarian");
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        userLabel.setForeground(TEXT_COLOR);

        header.add(titlePanel, BorderLayout.WEST);
        header.add(userLabel, BorderLayout.EAST);

        return header;
    }

    // ============================================================
    // DASHBOARD
    // ============================================================

    private void showDashboard() {

        contentPanel.removeAll();

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(BACKGROUND_COLOR);

        main.add(
                createHeader(
                        "Librarian Dashboard",
                        "Manage daily library operations"
                ),
                BorderLayout.NORTH
        );

        JPanel center = new JPanel();
        center.setBackground(BACKGROUND_COLOR);
        center.setBorder(new EmptyBorder(25, 30, 25, 30));

        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        // Cards
        JPanel cardsPanel = new JPanel(new GridLayout(1, 4, 20, 20));
        cardsPanel.setOpaque(false);

        cardsPanel.add(createCard(
                "Total Books",
                "1,250",
                "Books in library"
        ));

        cardsPanel.add(createCard(
                "Issued Books",
                "185",
                "Currently borrowed"
        ));

        cardsPanel.add(createCard(
                "Pending Returns",
                "24",
                "Due / overdue"
        ));

        cardsPanel.add(createCard(
                "Reservations",
                "17",
                "Waiting requests"
        ));

        center.add(cardsPanel);

        center.add(Box.createVerticalStrut(30));

        JLabel recentLabel = new JLabel("Recent Transactions");
        recentLabel.setFont(new Font("Segoe UI", Font.BOLD, 19));
        recentLabel.setForeground(TEXT_COLOR);

        center.add(recentLabel);
        center.add(Box.createVerticalStrut(12));

        // Table
        String[] columns = {
            "Member",
            "Book",
            "Action",
            "Date",
            "Status"
        };

        Object[][] data = {
            {"Mg Mg", "Java Programming", "Issue", "2026-09-08", "Completed"},
            {"Su Su", "Database Systems", "Return", "2026-09-08", "Completed"},
            {"Aung Aung", "Computer Networks", "Renew", "2026-09-07", "Completed"},
            {"Mya Mya", "Software Engineering", "Issue", "2026-09-07", "Completed"}
        };

        JTable table = new JTable(
                new DefaultTableModel(data, columns) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {
                        return false;
                    }
                }
        );

        table.setRowHeight(35);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 13)
        );

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(900, 250));

        center.add(scrollPane);

        main.add(center, BorderLayout.CENTER);

        contentPanel.add(main);

        refresh();
    }

    // ============================================================
    // DASHBOARD CARD
    // ============================================================

    private JPanel createCard(
            String title,
            String value,
            String description) {

        JPanel card = new JPanel();
        card.setBackground(CARD_COLOR);
        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(226, 232, 240)
                        ),
                        new EmptyBorder(20, 20, 20, 20)
                )
        );

        card.setLayout(
                new BoxLayout(card, BoxLayout.Y_AXIS)
        );

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );
        titleLabel.setForeground(SECONDARY_TEXT);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 30)
        );
        valueLabel.setForeground(TEXT_COLOR);

        JLabel descriptionLabel =
                new JLabel(description);

        descriptionLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 12)
        );
        descriptionLabel.setForeground(SECONDARY_TEXT);

        card.add(titleLabel);
        card.add(Box.createVerticalStrut(8));
        card.add(valueLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(descriptionLabel);

        return card;
    }

    // ============================================================
    // BOOKS
    // ============================================================

    private void showBooks() {

        contentPanel.removeAll();

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BACKGROUND_COLOR);

        panel.add(
                createHeader(
                        "Books / Catalogue",
                        "Search and manage library books"
                ),
                BorderLayout.NORTH
        );

        JPanel body = new JPanel(new BorderLayout(10, 10));
        body.setBackground(BACKGROUND_COLOR);
        body.setBorder(new EmptyBorder(25, 30, 25, 30));

        JPanel top = new JPanel(new BorderLayout(10, 10));
        top.setOpaque(false);

        JTextField searchField =
                new JTextField();

        searchField.setPreferredSize(
                new Dimension(300, 40)
        );

        JButton searchButton =
                new JButton("Search");

        JButton addButton =
                new JButton("Add Book");

        top.add(searchField, BorderLayout.CENTER);
        top.add(searchButton, BorderLayout.EAST);
        top.add(addButton, BorderLayout.WEST);

        body.add(top, BorderLayout.NORTH);

        String[] columns = {
            "Book ID",
            "Title",
            "Author",
            "ISBN",
            "Available",
            "Status"
        };

        Object[][] data = {
            {"B001", "Java Programming", "Herbert Schildt",
                "978-0001", "5", "Available"},
            {"B002", "Database Systems", "Elmasri",
                "978-0002", "2", "Available"},
            {"B003", "Computer Networks", "Tanenbaum",
                "978-0003", "0", "Unavailable"}
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(data, columns)
                );

        table.setRowHeight(35);

        body.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        panel.add(body, BorderLayout.CENTER);

        contentPanel.add(panel);

        refresh();
    }

    // ============================================================
    // ISSUE BOOK
    // ============================================================

    private void showIssueBook() {

        contentPanel.removeAll();

        JPanel panel = createOperationPanel(
                "Issue Book",
                "Issue a book to a library member"
        );

        JPanel form = createFormPanel();

        JTextField memberField =
                createTextField("Member ID");

        JTextField bookField =
                createTextField("Book ID");

        JButton issueButton =
                new JButton("Issue Book");

        form.add(createLabel("Member ID"));
        form.add(memberField);

        form.add(createLabel("Book ID"));
        form.add(bookField);

        form.add(new JLabel(""));
        form.add(issueButton);

        issueButton.addActionListener(e -> {

            if (memberField.getText().trim().isEmpty()
                    || bookField.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Member ID and Book ID."
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Book issue process completed."
            );
        });

        panel.add(form, BorderLayout.CENTER);

        contentPanel.add(panel);

        refresh();
    }

    // ============================================================
    // RETURN BOOK
    // ============================================================

    private void showReturnBook() {

        contentPanel.removeAll();

        JPanel panel = createOperationPanel(
                "Return Book",
                "Process returned books and calculate fines"
        );

        JPanel form = createFormPanel();

        JTextField loanField =
                createTextField("Loan ID");

        JButton returnButton =
                new JButton("Return Book");

        form.add(createLabel("Loan ID"));
        form.add(loanField);

        form.add(new JLabel(""));
        form.add(returnButton);

        returnButton.addActionListener(e -> {

            if (loanField.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Loan ID."
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Book return process completed."
            );
        });

        panel.add(form, BorderLayout.CENTER);

        contentPanel.add(panel);

        refresh();
    }

    // ============================================================
    // RENEW BOOK
    // ============================================================

    private void showRenewBook() {

        contentPanel.removeAll();

        JPanel panel = createOperationPanel(
                "Renew Book",
                "Extend the borrowing period of a book"
        );

        JPanel form = createFormPanel();

        JTextField loanField =
                createTextField("Loan ID");

        JButton renewButton =
                new JButton("Renew Book");

        form.add(createLabel("Loan ID"));
        form.add(loanField);

        form.add(new JLabel(""));
        form.add(renewButton);

        renewButton.addActionListener(e -> {

            if (loanField.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Loan ID."
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Book renewed successfully."
            );
        });

        panel.add(form, BorderLayout.CENTER);

        contentPanel.add(panel);

        refresh();
    }

    // ============================================================
    // RESERVATIONS
    // ============================================================

    private void showReservations() {

        contentPanel.removeAll();

        JPanel panel = createOperationPanel(
                "Reservations",
                "Manage member book reservations"
        );

        String[] columns = {
            "Reservation ID",
            "Member",
            "Book",
            "Reserved Date",
            "Queue Position",
            "Status"
        };

        Object[][] data = {
            {"R001", "Mg Mg", "Java Programming",
                "2026-09-07", "1", "Waiting"},
            {"R002", "Su Su", "Database Systems",
                "2026-09-08", "2", "Waiting"},
            {"R003", "Aung Aung", "Java Programming",
                "2026-09-08", "3", "Waiting"}
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(data, columns)
                );

        table.setRowHeight(35);

        panel.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // ============================================================
    // MEMBERS
    // ============================================================

    private void showMembers() {

        contentPanel.removeAll();

        JPanel panel = createOperationPanel(
                "Members",
                "View and manage library members"
        );

        String[] columns = {
            "Member ID",
            "Name",
            "Email",
            "Phone",
            "Status",
            "Borrowed Books"
        };

        Object[][] data = {
            {"M001", "Mg Mg", "mgmg@email.com",
                "0912345678", "Active", "2"},
            {"M002", "Su Su", "susu@email.com",
                "0923456789", "Active", "1"},
            {"M003", "Aung Aung", "aung@email.com",
                "0934567890", "Inactive", "0"}
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(data, columns)
                );

        table.setRowHeight(35);

        panel.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // ============================================================
    // FINES
    // ============================================================

    private void showFines() {

        contentPanel.removeAll();

        JPanel panel = createOperationPanel(
                "Fines",
                "View and manage member fines"
        );

        String[] columns = {
            "Fine ID",
            "Member",
            "Loan ID",
            "Amount",
            "Status"
        };

        Object[][] data = {
            {"F001", "Mg Mg", "L001",
                "$2.00", "Unpaid"},
            {"F002", "Su Su", "L002",
                "$1.00", "Paid"},
            {"F003", "Aung Aung", "L003",
                "$5.00", "Unpaid"}
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(data, columns)
                );

        table.setRowHeight(35);

        panel.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // ============================================================
    // NOTIFICATIONS
    // ============================================================

    private void showNotifications() {

        contentPanel.removeAll();

        JPanel panel = createOperationPanel(
                "Notifications",
                "View important library notifications"
        );

        String[] columns = {
            "Notification ID",
            "Member",
            "Type",
            "Message",
            "Status",
            "Date"
        };

        Object[][] data = {
            {"N001", "Mg Mg", "Overdue",
                "Book is overdue", "Unread", "2026-09-08"},
            {"N002", "Su Su", "Reservation",
                "Reserved book is available",
                "Read", "2026-09-08"},
            {"N003", "Aung Aung", "Return",
                "Book return reminder",
                "Unread", "2026-09-09"}
        };

        JTable table =
                new JTable(
                        new DefaultTableModel(data, columns)
                );

        table.setRowHeight(35);

        panel.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // ============================================================
    // REPORTS
    // ============================================================

    private void showReports() {

        contentPanel.removeAll();

        JPanel panel = createOperationPanel(
                "Reports",
                "View library operation reports"
        );

        JPanel buttons = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 15, 15)
        );

        buttons.setOpaque(false);

        JButton borrowingButton =
                new JButton("Borrowing Report");

        JButton overdueButton =
                new JButton("Overdue Report");

        JButton fineButton =
                new JButton("Fine Report");

        JButton inventoryButton =
                new JButton("Inventory Report");

        buttons.add(borrowingButton);
        buttons.add(overdueButton);
        buttons.add(fineButton);
        buttons.add(inventoryButton);

        panel.add(buttons, BorderLayout.NORTH);

        JTextArea reportArea =
                new JTextArea();

        reportArea.setFont(
                new Font("Consolas", Font.PLAIN, 14)
        );

        reportArea.setEditable(false);

        reportArea.setText(
                "Library Report\n\n"
                + "Total Books       : 1,250\n"
                + "Issued Books      : 185\n"
                + "Overdue Books     : 24\n"
                + "Reservations      : 17\n"
                + "Unpaid Fines      : $125.00\n"
        );

        panel.add(
                new JScrollPane(reportArea),
                BorderLayout.CENTER
        );

        contentPanel.add(panel);

        refresh();
    }

    // ============================================================
    // OPERATION PANEL
    // ============================================================

    private JPanel createOperationPanel(
            String title,
            String subtitle) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BACKGROUND_COLOR);

        panel.add(
                createHeader(title, subtitle),
                BorderLayout.NORTH
        );

        JPanel body = new JPanel(new BorderLayout());
        body.setBackground(BACKGROUND_COLOR);
        body.setBorder(
                new EmptyBorder(25, 30, 25, 30)
        );

        panel.add(body, BorderLayout.CENTER);

        return panel;
    }

    // ============================================================
    // FORM PANEL
    // ============================================================

    private JPanel createFormPanel() {

        JPanel form = new JPanel(
                new GridLayout(0, 2, 15, 15)
        );

        form.setBackground(Color.WHITE);

        form.setBorder(
                new EmptyBorder(30, 30, 30, 30)
        );

        return form;
    }

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );

        label.setForeground(TEXT_COLOR);

        return label;
    }

    private JTextField createTextField(String placeholder) {

        JTextField field = new JTextField();

        field.setPreferredSize(
                new Dimension(250, 35)
        );

        field.setToolTipText(placeholder);

        return field;
    }

    // ============================================================
    // REFRESH
    // ============================================================

    private void refresh() {

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }

            new LibrarianDashboard().setVisible(true);
        });
    }
}

