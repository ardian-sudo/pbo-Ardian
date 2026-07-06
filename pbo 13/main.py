import mysql.connector
from tabulate import tabulate  # Install dulu: pip install tabulate (untuk merapikan tabel CLI)

# 1. Koneksi ke Database
def get_db_connection():
    return mysql.connector.connect(
        host="localhost",
        user="root",          # Sesuaikan dengan user MySQL-mu
        password="",          # Sesuaikan dengan password MySQL-mu
        database="toko_retail"
    )

# 2. Fungsi Menu 1: Tampil Semua Data
def tampil_semua_data():
    db = get_db_connection()
    cursor = db.cursor()
    cursor.execute("SELECT kode, nama_barang, harga, stok FROM barang")
    results = cursor.fetchall()
    
    print("\n===============================================")
    print("           DAFTAR BARANG TOKO RETAIL           ")
    print("===============================================")
    
    if not results:
        print("Data kosong.")
    else:
        # Memformat tampilan menjadi tabel seperti pada soal
        headers = ["#", "Kode", "Nama Barang", "Harga", "Stok"]
        table_data = []
        for index, row in enumerate(results, start=1):
            table_data.append([index, row[0], row[1], row[2], row[3]])
        
        print(tabulate(table_data, headers=headers, tablefmt="grid"))
        print(f"Total: {len(results)} barang")
        
    cursor.close()
    db.close()

# 3. Fungsi Menu 2: Tambah Data
def tambah_data():
    kode = input("Masukkan Kode Barang: ")
    nama = input("Masukkan Nama Barang: ")
    harga = int(input("Masukkan Harga: "))
    stok = int(input("Masukkan Stok: "))
    
    db = get_db_connection()
    cursor = db.cursor()
    sql = "INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (%s, %s, %s, %s)"
    cursor.execute(sql, (kode, nama, harga, stok))
    db.commit()
    print("Data berhasil ditambahkan!")
    cursor.close()
    db.close()

# 4. Fungsi Menu 3: Cari Data
def cari_data():
    keyword = input("Masukkan Kode atau Nama Barang yang dicari: ")
    db = get_db_connection()
    cursor = db.cursor()
    sql = "SELECT kode, nama_barang, harga, stok FROM barang WHERE kode LIKE %s OR nama_barang LIKE %s"
    cursor.execute(sql, (f"%{keyword}%", f"%{keyword}%"))
    results = cursor.fetchall()
    
    if not results:
        print("Data tidak ditemukan.")
    else:
        headers = ["#", "Kode", "Nama Barang", "Harga", "Stok"]
        table_data = [[i, r[0], r[1], r[2], r[3]] for i, r in enumerate(results, start=1)]
        print(tabulate(table_data, headers=headers, tablefmt="grid"))
        
    cursor.close()
    db.close()

# 5. Fungsi Menu 4: Ubah Data
def ubah_data():
    kode = input("Masukkan Kode Barang yang ingin diubah: ")
    db = get_db_connection()
    cursor = db.cursor()
    
    # Cek apakah barang ada
    cursor.execute("SELECT * FROM barang WHERE kode = %s", (kode,))
    if not cursor.fetchone():
        print("Kode barang tidak ditemukan.")
        return
        
    nama = input("Nama Barang baru: ")
    harga = int(input("Harga baru: "))
    stok = int(input("Stok baru: "))
    
    sql = "UPDATE barang SET nama_barang=%s, harga=%s, stok=%s WHERE kode=%s"
    cursor.execute(sql, (nama, harga, stok, kode))
    db.commit()
    print("Data berhasil diubah!")
    cursor.close()
    db.close()

# 6. Fungsi Menu 5: Hapus Data
def hapus_data():
    kode = input("Masukkan Kode Barang yang ingin dihapus: ")
    db = get_db_connection()
    cursor = db.cursor()
    
    sql = "DELETE FROM barang WHERE kode = %s"
    cursor.execute(sql, (kode,))
    db.commit()
    
    if cursor.rowcount > 0:
        print("Data berhasil dihapus!")
    else:
        print("Kode barang tidak ditemukan.")
    cursor.close()
    db.close()

# Loop Utama Menu Aplikasi
def main():
    while True:
        print("\n+--------------------+")
        print("| MENU TOKO RETAIL   |")
        print("+--------------------+")
        print("| 1. Tampil Semua Data|")
        print("| 2. Tambah Data     |")
        print("| 3. Cari Data       |")
        print("| 4. Ubah Data       |")
        print("| 5. Hapus Data      |")
        print("| 0. Keluar          |")
        print("+--------------------+")
        
        pilihan = input("Pilihan : ")
        
        if pilihan == '1':
            tampil_semua_data()
        elif pilihan == '2':
            tambah_data()
        elif pilihan == '3':
            cari_data()
        elif pilihan == '4':
            ubah_data()
        elif pilihan == '5':
            hapus_data()
        elif pilihan == '0':
            print("Terima kasih!")
            break
        else:
            print("Pilihan tidak valid, silakan coba lagi.")

if __name__ == "__main__":
    main()