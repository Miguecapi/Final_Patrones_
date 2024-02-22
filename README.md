import tkinter as tk
from tkinter import simpledialog, messagebox

class VentasBusesGUI:
    def _init_(self, root):
        self.root = root
        self.root.title("Ventas de Busetas")
        self.root.geometry("600x400")

        self.output_text = tk.Text(root, height=10, width=60, state=tk.DISABLED)
        self.output_text.pack(pady=10)

        start_button = tk.Button(root, text="Iniciar Proceso", command=self.ejecutar_proceso)
        start_button.pack()

    def ejecutar_proceso(self):
        busetas = int(simpledialog.askstring("Ingresar", "Ingrese la cantidad de busetas:"))
        dias = 7

        ventas = [[0] * dias for _ in range(busetas)]

        self.almacenar_ventas(ventas, busetas, dias)
        self.mostrar_mensaje("Ventas almacenadas correctamente")

        self.buseta_que_mas_gana(ventas)
        self.buseta_que_menos_gana(ventas)
        self.dia_mas_ganancia_por_buseta(ventas)
        self.aumentar_ventas_bajas(ventas)

        self.mostrar_mensaje("Ventas actualizadas")
        self.imprimir_ventas(ventas)

    def almacenar_ventas(self, matriz, filas, columnas):
        for i in range(filas):
            for j in range(columnas):
                ventas_x_dia = int(simpledialog.askstring(
                    f"Ingresar",
                    f"Ingresar las ventas para la buseta {i + 1} para el día {j + 1}"
                ))
                matriz[i][j] = ventas_x_dia

    def buseta_que_mas_gana(self, ventas):
        total_semana = [sum(buseta) for buseta in ventas]
        buseta_mas_gana = total_semana.index(max(total_semana)) + 1
        max_ganancia = max(total_semana)
        self.mostrar_mensaje(f"La buseta que más gana en la semana es la número {buseta_mas_gana} con un total de ventas de {max_ganancia}")

    def buseta_que_menos_gana(self, ventas):
        total_semana = [sum(buseta) for buseta in ventas]
        buseta_menos_gana = total_semana.index(min(total_semana)) + 1
        min_ganancia = min(total_semana)
        self.mostrar_mensaje(f"La buseta que menos gana en la semana es la número {buseta_menos_gana} con un total de ventas de {min_ganancia}")

    def dia_mas_ganancia_por_buseta(self, ventas):
        for i, buseta in enumerate(ventas):
            max_ganancia = max(buseta)
            dia_mas_ganancia = buseta.index(max_ganancia) + 1
            self.mostrar_mensaje(f"La buseta {i + 1} gana más el día {dia_mas_ganancia} con ventas de {max_ganancia}")

    def aumentar_ventas_bajas(self, ventas):
        total_ventas = sum(sum(buseta) for buseta in ventas)
        total_elementos = sum(len(buseta) for buseta in ventas)

        promedio_diario = total_ventas / total_elementos
        self.mostrar_mensaje(f"El promedio diario de ventas es: {promedio_diario}")

        for i, buseta in enumerate(ventas):
            for j in range(len(buseta)):
                if buseta[j] < promedio_diario:
                    buseta[j] = int(buseta[j] * 1.20)

    def imprimir_ventas(self, ventas):
        self.output_text.config(state=tk.NORMAL)
        self.output_text.delete(1.0, tk.END)
        self.output_text.insert(tk.END, "Ventas actualizadas:\n")

        for i, buseta in enumerate(ventas):
            self.output_text.insert(tk.END, f"Buseta {i + 1}: {' '.join(map(str, buseta))}\n")

        self.output_text.config(state=tk.DISABLED)

    def mostrar_mensaje(self, mensaje):
        messagebox.showinfo("Mensaje", mensaje)


if _name_ == "_main_":
    root = tk.Tk()
    app = VentasBusesGUI(root)
    root.mainloop()
