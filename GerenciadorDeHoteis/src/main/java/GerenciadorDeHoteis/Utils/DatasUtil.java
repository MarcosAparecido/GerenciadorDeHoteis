/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class DatasUtil {

    public Date obtemDataHoje(JLabel lblDataCheckIn) {
        LocalDateTime dataAtual = LocalDateTime.now();
        Date dataConvertida = Date.from(dataAtual.atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
        String dataString = formatoData.format(dataConvertida);
        lblDataCheckIn.setText(dataString);
        return dataConvertida;
    }

    public Date obtemDataNascimento(String dataNascimento) {
        Date data = null;
        String dataString = dataNascimento;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            data = formato.parse(dataString);

        } catch (ParseException e) {
            System.out.println("Erro ao convrter string da data: " + e.getMessage());
        }
        return data;
    }

    public Date converterStringParaData(String dataString) {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date data = formatoEntrada.parse(dataString);
            System.out.println("Nova data como objeto Date: " + data);
            return data;

        } catch (ParseException e) {
            JOptionPane.showInternalMessageDialog(null, "O campo DATA DE CONSUMO deve conter um número válido.");
            System.out.println("O campo DATA DE CONSUMO deve ser um número válido." + e.getMessage());
            return null;
        }
    }

    public Date converterStringParaDataHoras(String dataString) {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date data = formatoEntrada.parse(dataString);

            Calendar agora = Calendar.getInstance();
            int horas = agora.get(Calendar.HOUR_OF_DAY);
            int minutos = agora.get(Calendar.MINUTE);
            int segundos = agora.get(Calendar.SECOND);
            int milissegundos = agora.get(Calendar.MILLISECOND);

            Calendar calendarioData = Calendar.getInstance();
            calendarioData.setTime(data);

            calendarioData.set(Calendar.HOUR_OF_DAY, horas);
            calendarioData.set(Calendar.MINUTE, minutos);
            calendarioData.set(Calendar.SECOND, segundos);
            calendarioData.set(Calendar.MILLISECOND, milissegundos);
            
            Date dataComHoraAtual = calendarioData.getTime();

            System.out.println("Nova data como objeto Date: " + dataComHoraAtual);
            return dataComHoraAtual;

        } catch (ParseException e) {
            JOptionPane.showInternalMessageDialog(null, "O campo DATA DE CONSUMO deve conter um número válido.");
            System.out.println("O campo DATA DE CONSUMO deve ser um número válido. " + e.getMessage());
            return null;
        }
    }

    public String converterDataParaString(Date date, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(date);
    }

    public boolean validaIdade(String dataNascimento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date nascimento = sdf.parse(dataNascimento);
            Calendar dataNascimentoCal = Calendar.getInstance();
            dataNascimentoCal.setTime(nascimento);
            Calendar hoje = Calendar.getInstance();
            int idade = hoje.get(Calendar.YEAR) - dataNascimentoCal.get(Calendar.YEAR);
            if (hoje.get(Calendar.DAY_OF_YEAR) < dataNascimentoCal.get(Calendar.DAY_OF_YEAR)) {
                idade--;
            }

            if (idade >= 18) {
                return true;
            } else {
                System.out.println("O Hóspede não possui mais de 18 anos.");
                return false;
            }
        } catch (ParseException e) {
            System.out.println("O Erro em comparar a idade ." + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public long compararDatas(Date checkIn, Date checkOut) {
        LocalDate inicioData = convertDateToLocalDate(checkIn);
        LocalDate fimData = convertDateToLocalDate(checkOut);
        if (inicioData == null || fimData == null) {
            throw new IllegalArgumentException("Date arguments cannot be null");
        }
        long diasDiferenca = calculaDiferencaEntreDias(inicioData, fimData);
        System.out.println("A diferença entre as datas é de " + diasDiferenca + " dias.");
        return diasDiferenca;
    }

    public long calculaDiferencaEntreDias(LocalDate inicioData, LocalDate fimData) {
        return ChronoUnit.DAYS.between(inicioData, fimData);
    }

    public static LocalDate convertDateToLocalDate(Date data) {
        if (data == null) {
            throw new IllegalArgumentException("A data não pode ser nula.");
        }
        Instant instant = null;
        if (data instanceof java.sql.Date) {
            instant = new Date(data.getTime()).toInstant();
        } else {
            instant = data.toInstant();
        }
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    public Date converterLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public List<LocalDate> obterDiferencaDatas(Date checkIn, Date checkOut) {
        LocalDate inicioData = convertDateToLocalDate(checkIn);
        LocalDate fimData = convertDateToLocalDate(checkOut);
        if (inicioData == null || fimData == null) {
            throw new IllegalArgumentException("Date arguments cannot be null");
        }
        List<LocalDate> todasAsDatas = getDatasEntre(inicioData, fimData);
        System.out.println("Todas as datas entre " + inicioData + " e " + fimData + " são: " + todasAsDatas);
        return todasAsDatas;
    }

    public List<LocalDate> getDatasEntre(LocalDate inicioData, LocalDate fimData) {
        List<LocalDate> datas = new ArrayList<>();
        long diasDiferenca = ChronoUnit.DAYS.between(inicioData, fimData);
        for (int i = 0; i <= diasDiferenca; i++) {
            datas.add(inicioData.plusDays(i));
        }
        return datas;
    }

}
