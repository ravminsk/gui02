package gui02;

import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MainFrame extends JFrame {
	private static final int DEFAULT_WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3);
	private static final int DEFAULT_HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3);

	// элементы основного окна
	JPanel panel3 = new JPanel();
	JButton bArchive = new JButton(" Добавить в архив... ");
	JButton bExtract = new JButton(" Извлечь из архива... ");

	JPanel panel4 = new JPanel();
	JTextArea txtArea = new JTextArea(6, 50);

	JPanel panel5 = new JPanel();

	// конструктор для инициализации окна
	public MainFrame(String title) {
		// setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		setLocationByPlatform(true);

		panel3.add(bArchive);
		panel3.add(bExtract);

		panel4.add(new JScrollPane(txtArea));

		panel5.setLayout(new GridLayout(2, 1));
		panel5.add(panel3);
		panel5.add(panel4);

		add(panel5);
		pack();

		bArchive.addActionListener(e -> {
			FileDialog fd = new FileDialog(this, "Выберите файл для сжатия", FileDialog.LOAD);
			fd.setVisible(true);
			String filename = fd.getFile();
			if (filename != null) {
				txtArea.append("Выбран файл для сжатия: " + fd.getDirectory() + "" + filename + "\n");
			}
		});

		bExtract.addActionListener(e -> {
			FileDialog fd = new FileDialog(this, "Выберите файл для извлечения из архива", FileDialog.LOAD);
			fd.setVisible(true);
			String filename = fd.getFile();
			if (filename != null) {
				txtArea.append("Выбран файл для извлечения: " + fd.getDirectory() + filename + "\n");
			}
		});

	}
}