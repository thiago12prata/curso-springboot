package com.practice.entities.enums;
//padrão de enum para evitar que o codigo quebre quando adicionado novo valor
public enum PedidoStatus {


	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int cod;
	
	private PedidoStatus(int cod) {
		this.cod = cod;
	}
	public int getCod() {
		return cod;
	}
	public static PedidoStatus valueOf(int cod) {
		for(PedidoStatus valor : PedidoStatus.values()) {
			if (valor.getCod()==cod) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Codigo do status do pedido incorreto");
	}
}
