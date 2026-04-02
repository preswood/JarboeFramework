package jarboe;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

public class JarboeWebPanel extends JarboePanel {
	private static final long serialVersionUID = 1L; //serial version added to fix issues with older java IDEs and compilers
	private static ArrayList history = new ArrayList();
	private static int currentPointInHistory = 0;
    private static JEditorPane editPane;
    private static JProgressBar progressBar;
    
    public JProgressBar getProgressBar() {
    	return progressBar;
    }
    
    private static void dump()
    {
    	System.out.println("History Length = " + history.size() + ", Current = " + currentPointInHistory + ", Diff = " + (history.size() - currentPointInHistory));
    }
    
    public JarboeWebPanel(String initialUrl) {
    	super();
        setLayout(new BorderLayout());
        editPane = new JEditorPane();
        editPane.setEditable(false);
        editPane.setContentType("text/html");

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(false);
        progressBar.setStringPainted(true);
        progressBar.setString("Ready");

        editPane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    loadPage(e.getURL().toString());
                }
            }
        });
        editPane.addPropertyChangeListener("page", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                // When the 'page' property stops changing, the load is done
                progressBar.setIndeterminate(false);
                progressBar.setValue(100);
                progressBar.setString("Done");
            }
        });

        JScrollPane scrollPane = new JScrollPane(editPane);
        add(scrollPane, BorderLayout.CENTER);

        loadPage(initialUrl);
    }

    private void displayPage(final String url) {
    	System.out.println("Now loading " + url);
    	trimHistory();
        progressBar.setIndeterminate(true);
        progressBar.setString("Loading...");
        Thread loader = new Thread(new Runnable() {
            public void run() {
                try {
                    editPane.setPage(url);
                } catch (IOException e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            progressBar.setIndeterminate(false);
                            progressBar.setString("Error");
                            editPane.setText("An error has occurred loading the page.");
                        }
                    });
                }
            }
        });
        loader.start();
    }
    
    public void loadPage(String url)
    {
    	history.add(url); currentPointInHistory++;
    	displayPage(url);
    }
    
    public void trimHistory()
    {
    	dump();
    	int diff = history.size() - 1 - currentPointInHistory;
    	for(int i=0; i<=diff; i++)
    	{
    		history.remove(currentPointInHistory);
    		System.out.println("Trimming " + i + " of " + diff);
    	}
    }
    
    public void previous()
    {
    	dump();
    	currentPointInHistory--;
    	if(currentPointInHistory<=0) {currentPointInHistory=1;} else {
    		try{displayPage((String) history.get(currentPointInHistory-1));} catch (Exception e) {};
    	}
    }
    
    public void reload()
    {
    	displayPage((String) history.get(currentPointInHistory-1));
    }
}