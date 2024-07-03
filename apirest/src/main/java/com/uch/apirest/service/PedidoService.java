package com.uch.apirest.service;

import com.uch.apirest.model.Pedido;
import com.uch.apirest.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido actualizarPedido(Long id, Pedido pedido) {
        Pedido pedidoExistente = pedidoRepository.findById(id).orElse(null);
        if (pedidoExistente != null) {
            pedidoExistente.setCantidad(pedido.getCantidad());
            pedidoExistente.setNombreCliente(pedido.getNombreCliente());
            pedidoExistente.setCereal(pedido.getCereal());
            return pedidoRepository.save(pedidoExistente);
        }
        return null;
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
