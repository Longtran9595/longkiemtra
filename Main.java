import java.util.ArrayList;
import java.util.Scanner;

class sanPham {
    private int id;
    private String ten;
    private int soLuong;
    private double gia;
    private String loaiSanpham;

    public sanPham(int id, String ten, int soLuong, double gia, String loaiSanpham) {
        this.id = id;
        this.ten = ten;
        this.soLuong = soLuong;
        this.gia = gia;
        this.loaiSanpham = loaiSanpham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getLoaiSanpham() {
        return loaiSanpham;
    }

    public void setLoaiSanpham(String loaiSanpham) {
        this.loaiSanpham = loaiSanpham;
    }
}

class quanLySanPham {
    public ArrayList<sanPham> sanPhams;

    public quanLySanPham() {
        sanPhams = new ArrayList<>();
    }

    public void themSanPham(sanPham sp) {
        sanPhams.add(sp);
    }

    public void suaSanPham(int id, String ten, int soLuong, double gia, String loaiSanpham) {
        for (sanPham sp : sanPhams) {
            if (sp.getId() == id) {
                sp.setGia(gia);
                sp.setTen(ten);
                sp.setSoLuong(soLuong);
                sp.setLoaiSanpham(loaiSanpham);
                return;
            }
        }
        System.out.println("khong tim thay san pham co id " + id);
    }

    public void xoaSanPham(int id) {
        for (sanPham sp : sanPhams) {
            if (sp.getId() == id) {
                sanPhams.remove(sp);
                return;
            }
        }
        System.out.println("khong tim thay san pham can xoa co id " + id);
    }

    public ArrayList<sanPham> getAll() {
        return sanPhams;
    }

    public ArrayList<sanPham> timTheoTenGanDung(String ten) {
        ArrayList<sanPham> ketqua = new ArrayList<>();
        for (sanPham sp : sanPhams) {
            if (sp.getTen().toLowerCase().contains(ten.toLowerCase())) {
                ketqua.add(sp);
            }
        }
        return ketqua;
    }

    public sanPham timTheoLoaiSanPham(String loaiSanpham) {
        for (sanPham sp : sanPhams) {
            if (sp.getLoaiSanpham() == loaiSanpham) {
                return sp;
            }
        }
        return null;
    }

    public sanPham timTheoID(int id) {
        for (sanPham sp : sanPhams) {
            if (sp.getId() == id) {
                return sp;
            }
        }
        return null;
    }






}

class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        quanLySanPham qlsp = new quanLySanPham();
        ArrayList<sanPham> DanhsachSP = qlsp.getAll();

        while (true) {
            System.out.println("======MENU======");
            System.out.println("1. Them san pham");
            System.out.println("2. Sua san pham theo id");
            System.out.println("3. Nhap ID san pham can xoa");
            System.out.println("4. Hien thi toan bo san pham");
            System.out.println("5. Nhap ten gan dung de tim kiem");
            System.out.println("6. Nhap loai san pham can hien thi");
            System.out.println("7. Nhap ID san pham can tim");
            System.out.println("8. Dung chuong trinh");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhap ID");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nhap ten");
                    String ten = scanner.nextLine();

                    System.out.println("Nhap so luong");
                    int soLuong = scanner.nextInt();

                    System.out.println("Nhap gia");
                    double gia = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Nhap loai san pham");
                    String loaiSanPham = scanner.nextLine();

                    sanPham sp = new sanPham(id, ten, soLuong, gia, loaiSanPham);
                    qlsp.themSanPham(sp);
                    break;


                case 2:
                    System.out.println("nhap ID can sua");
                    int idcansua = scanner.nextInt();
                    sanPham sanphamcansua = qlsp.timTheoID(idcansua);
                    if (sanphamcansua != null) {
                        System.out.println("Nhap thong tin can sua");
                        System.out.println("nhap ID moi");
                        int idSua = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Ten moi");
                        String tenSua = scanner.nextLine();
                        System.out.println("so luong moi");
                        int soluongSua = scanner.nextInt();

                        System.out.println("gia moi");
                        int giaSua = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("loai san pham moi");
                        String loaisanphamSua = scanner.nextLine();

                        qlsp.suaSanPham(idSua, tenSua, soluongSua, giaSua,loaisanphamSua);
                    }else {
                        System.out.println("k co id thich hop");
                    }
                    break;
                case 3:
                    System.out.println("nhap id san pham can xoa");
                    int idXoa = scanner.nextInt();
                    sanPham sanPhamCanXoa = qlsp.timTheoID(idXoa);
                    if (sanPhamCanXoa != null) {
                        qlsp.xoaSanPham(idXoa);
                    }else {
                        System.out.println("k co id");
                    }
                    break;
                case 4:
                    System.out.println("hien thi toan bo san pham");
                    for (sanPham Sp : DanhsachSP) {
                        System.out.println("ID: " + Sp.getId() + ", Ten: " +Sp.getTen() + ", so luong" + Sp.getSoLuong() + ", gia " + Sp.getGia() + " , loai san pham" + Sp.getLoaiSanpham());
                    }
                    break;

                case 5:
                    System.out.println("nhap ten can tim kiem");
                    String tenCanTim = scanner.nextLine();
                    ArrayList<sanPham> Ketquatim = qlsp.timTheoTenGanDung(tenCanTim);
                    if(!tenCanTim.isEmpty()){
                        System.out.println("Kết quả tìm kiếm:");
                        for (sanPham spTim : Ketquatim) {
                            System.out.println("ID: " + spTim.getId() + ", Ten: " +spTim.getTen() + ", so luong" + spTim.getSoLuong() + ", gia " + spTim.getGia() + " , loai san pham" + spTim.getLoaiSanpham());
                        }
                    } else {
                        System.out.println("Không tìm thấy sinh viên có tên gần đúng ");
                    }
                    break;
                case 6:
                    System.out.println("nhap loai san pham can hien thi");
                    String loaiSpcanHienThi = scanner.nextLine();
                    sanPham sptheoloai = qlsp.timTheoLoaiSanPham(loaiSpcanHienThi);
                    for (sanPham S : qlsp.sanPhams){
                        if(sptheoloai != null){
                            System.out.println(sptheoloai);
                        }
                    }
                    break;
                case 7:
                    System.out.println("nhap id san pham can tim");
                    int Idtim = scanner.nextInt();
                    sanPham sptheoID = qlsp.timTheoID(Idtim);
                    if(sptheoID != null){
                        System.out.println(sptheoID);
                    }
                    break;
                case 8:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ.");
                    break;

            }
        }
    }
}