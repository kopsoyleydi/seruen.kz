package bek.kino.ticket.two.qrCode;

public interface QrCodeGenerator {
	byte [] generateQrCode(String grContent, int width, int height);
}
