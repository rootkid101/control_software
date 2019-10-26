package classes;

public class OpenWebcam {
    private String ipWebcam;

    public OpenWebcam(String ip) {
        GUI gui = new GUI();
        this.ipWebcam = ip;
        if( !java.awt.Desktop.isDesktopSupported() ) {

            System.err.println( "Desktop is not supported (fatal)" );
            System.exit( 1 );
        }


        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

        if( !desktop.isSupported( java.awt.Desktop.Action.BROWSE ) ) {

            System.err.println( "Desktop doesn't support the browse action (fatal)" );
            System.exit( 1 );
        }

        if( desktop.isSupported( java.awt.Desktop.Action.BROWSE ) ) {

            try {

                java.net.URI uri = new java.net.URI("http://" + ipWebcam);
                desktop.browse( uri );
            }
            catch ( Exception e ) {

                System.err.println( e.getMessage() );
            }
        }
    }
}
