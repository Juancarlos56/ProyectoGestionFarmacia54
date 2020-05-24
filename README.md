# ProyectoGestionFarmacia54
Proyecto fin de ciclo, facturación de una farmacia
Codigo para colocar imagen de fondo

escritorio = new javax.swing.JDesktopPane(){
    public void paintComponent(Graphics g) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/wel.jpg"));
        Image fondo = icon.getImage();
        int h , w;
        h = this.getSize().height;	//Alto
        w = this.getSize().width;	//Largo
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, w, h, this);
    }
}
