/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.xuongoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class SinhVien_Service {

    ArrayList<SinhVien> list = new ArrayList<>();

    public void nhapDanhSach() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Chon chuyen nganh: ");
            System.out.println("1. IT | 2. Marketing | 3. Ngon ngu | 4. Kinh te | 5. Co khi | 0. Thoat");
            int chon = sc.nextInt();
            switch (chon) {
                case 1:
                    SinhVienIT it = new SinhVienIT();
                    it.nhap();
                    list.add(it);
                    break;

                case 2:
                    SinhVienMarketing mk = new SinhVienMarketing();
                    mk.nhap();
                    list.add(mk);
                    break;

                case 3:
                    SinhVienNgonNgu nn = new SinhVienNgonNgu();
                    nn.nhap();
                    list.add(nn);
                    break;

                case 4:
                    SinhVienKinhTe kt = new SinhVienKinhTe();
                    kt.nhap();
                    list.add(kt);
                    break;

                case 5:
                    SinhVienCoKhi ck = new SinhVienCoKhi();
                    ck.nhap();
                    list.add(ck);
                    break;

                default:
                    System.out.println("Ngoai chuong trinh!");
            }
            if (chon == 0) {
                break;
            }
        } while (true);
    }

    public void xuatDanhSach() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                    "MaSV", "HoTen", "NamSinh", "Nganh", "PTCN", "Triet", "TiengAnh", "C.Nganh 1", "C.Nganh 2", "DiemTB", "XepLoai");
            for (SinhVien sv : list) {
                sv.xuat();
            }
        }
    }
    
    
    public void nhap1(SinhVien sv) {
        if (sv instanceof SinhVienIT) {
            ((SinhVienIT) sv).nhap();
        } else if (sv instanceof SinhVienMarketing) {
            ((SinhVienMarketing) sv).nhap();
        } else if (sv instanceof SinhVienNgonNgu) {
            ((SinhVienNgonNgu) sv).nhap();
        } else if (sv instanceof SinhVienKinhTe) {
            ((SinhVienKinhTe) sv).nhap();
        } else if (sv instanceof SinhVienCoKhi) {
            ((SinhVienCoKhi) sv).nhap();
        }
    }

    public void timSV() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ma SV can tim: ");
            String id = sc.nextLine();
            boolean flag = false;
            for (SinhVien sv : list) {
                if (sv.getMaSV().equalsIgnoreCase(id)) {
                    System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                    "MaSV", "HoTen", "NamSinh", "Nganh", "PTCN", "Triet", "TiengAnh", "C.Nganh 1", "C.Nganh 2", "DiemTB", "XepLoai");
                    sv.xuat();
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("Khong tim thay sinh vien! ");
            }
        }
    }

    public void xoaSV() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ma SV can xoa: ");
            String id = sc.nextLine();
            boolean flag = false;
            for (SinhVien sv : list) {
                if (sv.getMaSV().equalsIgnoreCase(id)) {
                    list.remove(sv);
                    System.out.println("Da xoa sinh vien co ma SV: " + id);
                    xuatDanhSach();
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("Khong tim thay sinh vien! ");
            }
        }
    }

    public void capNhat() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ma nv can cap nhat:");
            String id = String.valueOf(sc.nextLine());
            boolean flag = false;
            for (SinhVien sv : list) {
                if (id.equalsIgnoreCase(sv.getMaSV())) {
                    if (sv instanceof SinhVienIT) {
                        ((SinhVienIT) sv).nhap();
                    } else if (sv instanceof SinhVienMarketing) {
                        ((SinhVienMarketing) sv).nhap();
                    } else if (sv instanceof SinhVienKinhTe) {
                        ((SinhVienKinhTe) sv).nhap();
                    } else if (sv instanceof SinhVienNgonNgu) {
                        ((SinhVienNgonNgu) sv).nhap();
                    } else if (sv instanceof SinhVienCoKhi) {
                        ((SinhVienCoKhi) sv).nhap();
                    }
                    xuatDanhSach();
                }
                flag = true;

            }
            if (flag == false) {
                System.out.println("Khong tim thay sinh vien ");
            }
        }
    }

    public void timDiem() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            Scanner sc = new Scanner(System.in);
            double start, end;
            do {
                do {
                    System.out.println("Nhap khoang diem bat dau:");
                    start = sc.nextDouble();
                } while (start < 0 || start > 10);
                do {
                    System.out.println("Nhap khoang diem ket thuc:");
                    end = sc.nextDouble();
                } while (end < 0 || end > 10);
                if (start > end) {
                    System.out.println("nhap lai");
                } else {
                    break;
                }
            } while (true);
            boolean flag = false;
            for (SinhVien sv : list) {
                if (sv.diemTB() >= start && sv.diemTB() <= end) {
                    System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                            "MaSV", "HoTen", "NamSinh", "Nganh", "Toan", "Triet", "TiengAnh", "Diem 1", "Diem 2", "DiemTB", "XepLoai");
                    break;
                }
            }
            for (SinhVien sv : list) {
                if (sv.diemTB() >= start && sv.diemTB() <= end) {
                    sv.xuat();
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Khong tim thay sinh vien ");
            }
        }
    }

    public void sapXepTen() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            Collections.sort(list, (sv1, sv2) -> sv1.getHoTen().compareTo(sv2.getHoTen()));
            xuatDanhSach();
        }
    }

    public void sapxepDiemTB() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            Collections.sort(list, (sv1, sv2) -> Double.compare(sv1.diemTB(), sv2.diemTB()));
            xuatDanhSach();
        }
    }

    public void soLuong() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            int soLuong;
            soLuong = list.size();
            System.out.println("So luong sinh vien: " + soLuong);
        }
    }

    public void tinhDiemTB() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            double DiemTB = 0;
            if (!list.isEmpty()) {
                for (SinhVien sinhVien : list) {
                    DiemTB = DiemTB + sinhVien.diemTB();
                }
                DiemTB = DiemTB / list.size();
                System.out.println("Diem trung binh cua tat ca sinh vien la: " + DiemTB);
            }
        }
    }

    public void SVDiemCaoNhat() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            System.out.println("Sinh vien co diem cao nhat");
            Collections.sort(list, (sv1, sv2) -> Double.compare(sv2.diemTB(), sv1.diemTB()));
            System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                    "MaSV", "HoTen", "NamSinh", "Nganh", "PTCN", "Triet", "TiengAnh", "C.Nganh 1", "C.Nganh 2", "DiemTB", "XepLoai");
            for (SinhVien sinhVien : list) {
                sinhVien.xuat();
                break;
            }
        }
    }
    
    public void SVDiemThapNhat() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            System.out.println("Sinh vien co diem thap nhat");
            Collections.sort(list, (sv1, sv2) -> Double.compare( sv1.diemTB(), sv2.diemTB()));
            System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                    "MaSV", "HoTen", "NamSinh", "Nganh", "PTCN", "Triet", "TiengAnh", "C.Nganh 1", "C.Nganh 2", "DiemTB", "XepLoai");
            for (SinhVien sinhVien : list) {
                sinhVien.xuat();
                break;
            }
        }
    }
    
    public void themTuDong(){
        list.add(new SinhVienIT("SV020", "Nguyen Manh Dung", 2005, "IT", 10, 10, 10, 10, 10));
        list.add(new SinhVienIT("SV021", "Tran Nhu Mai", 2003, "IT", 7.5, 8.0, 9.5, 7.0, 8.5));
        list.add(new SinhVienIT("SV022", "Le Phuong Nam", 2004, "IT", 6, 8.5, 8.0, 8.4, 7.0));
        list.add(new SinhVienMarketing("SV023", "Nguyen Thi Hoa", 2005, "Marketing", 7.4, 8.8, 8.0, 8.4, 7.0));
        list.add(new SinhVienMarketing("SV024", "Tran Ha Tuyet", 2005, "Marketing", 8.9, 8.8, 8.0, 5.6, 8.2));
        list.add(new SinhVienMarketing("SV025", "Hoang Mai Huong", 2005, "Marketing", 7, 9, 8.0, 3.5, 7.0));
        list.add(new SinhVienKinhTe("SV026", "Do Thi Trang", 2005, "Kinh te", 9.4, 9, 8.0, 7.8, 7.0));
        list.add(new SinhVienKinhTe("SV027", "Tran Anh Tuan", 2004, "Kinh te", 2.4, 5.6, 4.4, 7.6, 3.6));
        list.add(new SinhVienKinhTe("SV028", "Nguyen Anh Tai", 2002, "Kinh te", 5.6, 8, 8.0, 7.8, 7.0));
        list.add(new SinhVienNgonNgu("SV029", "Tran Hoang Nam", 2005, "Ngon ngu", 8.8, 8, 8.0, 7.8, 7.0));
        list.add(new SinhVienNgonNgu("SV030", "Nguyen Linh Chi", 2005, "Ngon ngu", 9,7.8, 8.0, 7.8, 8.5));
        list.add(new SinhVienNgonNgu("SV031", "Tran Thi Hien", 2003, "Ngon ngu", 6.6, 8, 5.5, 7.8, 7.0));
        list.add(new SinhVienCoKhi("SV032", "Nguyen Hong Son", 2005, "Co khi", 8.6, 8, 9.0, 8.5, 9.0));
        list.add(new SinhVienCoKhi("SV033", "Nguyen Hoang Hai", 2005, "Co khi", 5.6, 8, 7.8, 4.5, 7.6));
        list.add(new SinhVienCoKhi("SV034", "Hoang Minh Dang", 2005, "Co khi", 8, 8, 6.5, 8.5, 6.7));
        xuatDanhSach();
    }
    
    public void clear(){
        Scanner sc = new Scanner(System.in);
        String hoi = "";
        System.out.println("Ban co muon xoa toan bo sinh vien");
        try {
            System.out.println("1. Co | 0. Khong");
            hoi = sc.nextLine();
            if(hoi.equalsIgnoreCase("1")){
                list.clear();
                System.out.println("Da xoa toan bo sinh vien");
            } else {
                System.out.println("Khong xoa sinh vien");
            }
        } catch (Exception e) {
            System.out.println("Nhap loi");
            return;
        }
    }
}
