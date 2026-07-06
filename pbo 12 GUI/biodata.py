import tkinter as tk

# Fungsi untuk menampilkan data ke bagian output
def tampilkan_data():
    nim = entry_nim.get()
    nama = entry_nama.get()
    prodi = entry_prodi.get()
    
    # Format teks output
    output_text = (
        "========== BIODATA MAHASISWA ==========\n\n"
        "NIM           : {}\n"
        "Nama          : {}\n"
        "Program Studi : {}"
    ).format(nim, nama, prodi)
    
    # Memasukkan teks ke Text widget (ubah state dulu agar bisa diedit)
    text_output.config(state=tk.NORMAL)
    text_output.delete("1.0", tk.END)
    text_output.insert(tk.END, output_text)
    text_output.config(state=tk.DISABLED) # Dikembalikan ke disabled supaya user tidak bisa ngetik manual di area output

# Fungsi untuk mereset input dan output
def reset_data():
    # Bersihkan input fields
    entry_nim.delete(0, tk.END)
    entry_nama.delete(0, tk.END)
    entry_prodi.delete(0, tk.END)
    
    # Bersihkan output area
    text_output.config(state=tk.NORMAL)
    text_output.delete("1.0", tk.END)
    text_output.config(state=tk.DISABLED)

# Membuat jendela utama
root = tk.Tk()
root.title("Aplikasi Biodata Mahasiswa")
root.geometry("500x450")
root.configure(bg="#f0f0f0")

# --- Bagian Input Data ---
frame_input = tk.LabelFrame(root, text="Input Data", font=("Arial", 10, "bold"), bg="#f0f0f0", padx=10, pady=10)
frame_input.pack(fill="x", padx=15, pady=10)

# Label & Entry NIM
tk.Label(frame_input, text="NIM", bg="#f0f0f0", font=("Arial", 10)).grid(row=0, column=0, sticky="w", pady=5)
entry_nim = tk.Entry(frame_input, font=("Arial", 10), width=40)
entry_nim.grid(row=0, column=1, padx=10, pady=5)

# Label & Entry Nama
tk.Label(frame_input, text="Nama", bg="#f0f0f0", font=("Arial", 10)).grid(row=1, column=0, sticky="w", pady=5)
entry_nama = tk.Entry(frame_input, font=("Arial", 10), width=40)
entry_nama.grid(row=1, column=1, padx=10, pady=5)

# Label & Entry Program Studi
tk.Label(frame_input, text="Program Studi", bg="#f0f0f0", font=("Arial", 10)).grid(row=2, column=0, sticky="w", pady=5)
entry_prodi = tk.Entry(frame_input, font=("Arial", 10), width=40)
entry_prodi.grid(row=2, column=1, padx=10, pady=5)

# --- Bagian Tombol ---
frame_btn = tk.Frame(root, bg="#f0f0f0")
frame_btn.pack(pady=10)

btn_tampilkan = tk.Button(frame_btn, text="Tampilkan", width=12, command=tampilkan_data)
btn_tampilkan.grid(row=0, column=0, padx=10)

btn_reset = tk.Button(frame_btn, text="Reset", width=12, command=reset_data)
btn_reset.grid(row=0, column=1, padx=10)

# --- Bagian Output ---
frame_output = tk.LabelFrame(root, text="Output", font=("Arial", 10, "bold"), bg="#f0f0f0", padx=10, pady=10)
frame_output.pack(fill="both", expand=True, padx=15, pady=10)

text_output = tk.Text(frame_output, font=("Courier New", 10), bg="white", height=10, state=tk.DISABLED)
text_output.pack(fill="both", expand=True)

# Menjalankan aplikasi
root.mainloop()