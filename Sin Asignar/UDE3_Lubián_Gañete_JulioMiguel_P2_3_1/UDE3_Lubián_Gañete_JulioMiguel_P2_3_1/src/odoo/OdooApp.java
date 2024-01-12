/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package odoo;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;

/**
 *
 * @author Lubián_Gañete_Julio_Miguel
 */
public class OdooApp extends JFrame {

    private DefaultTableModel tableModel;

    public OdooApp() throws MalformedURLException, XmlRpcException {
        super("Datos de res.partner");

        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        tableModel.addColumn("Nombre");
        tableModel.addColumn("Calle");
        tableModel.addColumn("Ciudad");
        tableModel.addColumn("Teléfono");
        tableModel.addColumn("Móvil");

        JScrollPane scrollPane = new JScrollPane(table);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JButton exportButton = new JButton("Exportar a PDF");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportToPDF();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(exportButton);

        add(buttonPanel, BorderLayout.SOUTH);

        try {
            List<Map<String, Object>> partnerResults = Odoo.odooTest();
            fillTableWithData(partnerResults);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    private void fillTableWithData(List<Map<String, Object>> partnerResults) {
        for (Map<String, Object> partner : partnerResults) {
            String name = partner.get("name").toString();
            String street = partner.get("street").toString();
            String city = partner.get("city").toString();
            String phone = partner.get("phone").toString();
            String mobile = partner.get("mobile").toString();

            if ("false".equals(mobile)) {
                mobile = "";
            }

            if ("false".equals(name)) {
                mobile = "";
            }
            if ("false".equals(street)) {
                mobile = "";
            }
            if ("false".equals(city)) {
                mobile = "";
            }
            if ("false".equals(phone)) {
                mobile = "";
            }
            String[] rowData = {
                name,
                street,
                city,
                phone,
                mobile
            };

            tableModel.addRow(rowData);
        }
    }

    private void exportToPDF() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getPath();
                if (!filePath.toLowerCase().endsWith(".pdf")) {
                    filePath += ".pdf";
                }

                PdfWriter writer = new PdfWriter(filePath);
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);

                Table table = new Table(tableModel.getColumnCount());
                for (int col = 0; col < tableModel.getColumnCount(); col++) {
                    table.addCell(tableModel.getColumnName(col));
                }

                for (int row = 0; row < tableModel.getRowCount(); row++) {
                    for (int col = 0; col < tableModel.getColumnCount(); col++) {
                        table.addCell(tableModel.getValueAt(row, col).toString());
                    }
                }

                document.add(table);

                document.close();
                JOptionPane.showMessageDialog(this, "Tabla exportada a PDF correctamente", "Exportación Exitosa", JOptionPane.INFORMATION_MESSAGE);

            } catch (FileNotFoundException e) {
                Logger logger = LoggerFactory.getLogger(OdooApp.class);
                logger.error("Error al exportar la tabla a PDF", e);
                JOptionPane.showMessageDialog(this, "Error al exportar la tabla a PDF", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new OdooApp();
            } catch (XmlRpcException | MalformedURLException ex) {
                Logger logger = LoggerFactory.getLogger(OdooApp.class);
                logger.error("Error al iniciar la aplicación", ex);
            }
        });
    }
}
